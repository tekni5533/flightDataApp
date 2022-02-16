package com.ordina.aditya.api;

import com.ordina.aditya.api.model.AddRegionRequest;
import com.ordina.aditya.api.model.AddRegionResponse;
import com.ordina.aditya.api.model.FlightData;
import com.ordina.aditya.api.model.FlightsOverRegionResponse;
import com.ordina.aditya.service.SkyDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;

@Component
public class FlightApiRouter {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightApiRouter.class);

    SkyDataService skyDataService;

    public FlightApiRouter(SkyDataService skyDataService) {
        this.skyDataService = skyDataService;
    }

    @Bean
    public RouterFunction<ServerResponse> router() {

        return RouterFunctions
                .route(RequestPredicates.GET("/flightState")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), this::flightState)
                .andRoute(RequestPredicates.PUT("/addRegion")
                        .and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), this::addRegion)
                .andRoute(RequestPredicates.GET("/flightsOverRegion/{regionName}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), this::flightsOverRegion);
    }

    private Mono<ServerResponse> addRegion(ServerRequest req) {

        Mono<AddRegionResponse> flightState = req.body(toMono(AddRegionRequest.class))
                .map(skyDataService::addRegion);
        return flightState
                .flatMap(f -> {
                    LOGGER.info("addRegion request processed : {}", f.getMessage());
                    return ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                            .body(flightState, AddRegionResponse.class);
                });
    }

    private Mono<ServerResponse> flightsOverRegion(ServerRequest req) {
        String country = req.pathVariable("regionName");
        Mono<FlightsOverRegionResponse> flightState = skyDataService.getFlightsOverRegion(country);
        return flightState
                .flatMap(f -> {
                    LOGGER.info("Request received to fetch flights over region : {}", country);
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flightState, FlightsOverRegionResponse.class);
                })
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    private Mono<ServerResponse> flightState(ServerRequest req) {
        Mono<FlightData> flightState = skyDataService.getData();
        return flightState
                .flatMap(f -> {
                    LOGGER.info("Request received to fetch live flight data");
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flightState, FlightData.class);
                })
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
