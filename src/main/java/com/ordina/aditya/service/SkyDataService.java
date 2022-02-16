package com.ordina.aditya.service;

import com.ordina.aditya.api.model.*;
import com.ordina.aditya.config.SkyDataProperties;
import com.ordina.aditya.dto.FlightDataPointDtoList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class SkyDataService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SkyDataService.class);

    SkyDataProperties skyDataProperties;
    WebClient webClient;
    Map<String, RegionData> definedRegions;

    public SkyDataService(WebClient webClient, SkyDataProperties skyDataProperties) {
        this.webClient = webClient;
        this.skyDataProperties = skyDataProperties;
        this.definedRegions = new HashMap<>();
    }

    public Mono<FlightData> getData() {
        return webClient.get()
                .uri(skyDataProperties.getBaseUrl() + skyDataProperties.getApiUri())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FlightData.class)
                .onErrorResume(e -> {
                    LOGGER.error(" Error while invoking api call ", e);
                    return Mono.empty();
                });
    }

    public AddRegionResponse addRegion(AddRegionRequest addRegionRequest) {
        LOGGER.info("Request received to add region: {}", addRegionRequest.getRegionName());
        String regionToBeAdded = addRegionRequest.getRegionName();
        AddRegionResponse addRegionResponse;
        RegionData regionData = new RegionData()
                .setLatitudeMax(addRegionRequest.getLatitudeMax())
                .setLatitudeMin(addRegionRequest.getLongitudeMin())
                .setLongitudeMax(addRegionRequest.getLongitudeMax())
                .setLongitudeMin(addRegionRequest.getLongitudeMin());

        if (!definedRegions.containsKey(regionToBeAdded)) {
            LOGGER.info("Region: {}  does not exist. Adding the region", addRegionRequest.getRegionName());
            definedRegions.put(regionToBeAdded, regionData);
            addRegionResponse = new AddRegionResponse(Constants.REGION_ADDED, regionToBeAdded, regionData);
        } else {
            LOGGER.info("Region: {}  already exists ", addRegionRequest.getRegionName());
            addRegionResponse = new AddRegionResponse(Constants.REGION_EXISTS, regionToBeAdded, regionData);
        }
        return addRegionResponse;
    }

    public Mono<FlightsOverRegionResponse> getFlightsOverRegion(String regionName) {
        Mono<FlightsOverRegionResponse> result;
        if (!definedRegions.containsKey(regionName)) {
            result = Mono.empty();
        } else {
            RegionData regionData = definedRegions.get(regionName);
            String queryString = String.format(skyDataProperties.getRegionQueryString()
                    , regionData.getLatitudeMin()
                    , regionData.getLongitudeMin()
                    , regionData.getLatitudeMax()
                    , regionData.getLongitudeMax());

            result = webClient.get()
                    .uri(skyDataProperties.getBaseUrl() + skyDataProperties.getApiUri() + queryString)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(FlightData.class)
                    .map(flightDataResponse -> {
                        int time = flightDataResponse.getTime();
                        FlightDataPointDtoList flightDataPointDtoList = new FlightDataPointDtoList();
                        flightDataResponse.getStates().stream()
                                .forEach(flightDataPoint -> flightDataPointDtoList.add(
                                        time, flightDataPoint
                                ));
                        return flightDataPointDtoList;
                    })
                    .flatMapMany(Flux::fromIterable)
                    .groupBy(flightDataPointDto -> flightDataPointDto.getIcao24() + (Objects.nonNull(flightDataPointDto.getCallSign()) ? flightDataPointDto.getCallSign() : ""))
                    .flatMap(idFlux -> idFlux
                            .collectList()
                            .map(flightDataPointDtos ->
                                    new FlightCallData(idFlux.key(), flightDataPointDtos)
                            )
                    )
                    .collectList()
                    .map(flightCallData -> new FlightsOverRegionResponse(flightCallData.size(), regionData, regionName))
                    .onErrorResume(e -> {
                        LOGGER.error(" Error while invoking api call ", e);
                        return Mono.empty();
                    });

        }
        return result;
    }
}
