import com.ordina.aditya.ReactiveAssignmentApplication;
import com.ordina.aditya.api.FlightApiRouter;
import com.ordina.aditya.api.model.*;
import com.ordina.aditya.service.SkyDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ReactiveAssignmentApplication.class)
public class FlightApiRouterTests {

    @Autowired
    FlightApiRouter flightApiRouter;

    @MockBean
    SkyDataService skyDataService;

    WebTestClient client;

    @BeforeEach
    public void setup() {
        client = WebTestClient
                .bindToRouterFunction(flightApiRouter.router())
                .build();
    }

    @Test
    public void whenGetFlightsOverRegion_thenFlightsOverRegion() {
        String regionName = "Netherlands";
        Double latitudeMax = 47.8229;
        Double latitudeMin = 5.9962;
        Double longitudeMax = 10.5226;
        Double longitudeMin = 5.9962;

        FlightsOverRegionResponse flightsOverRegionResponse = new FlightsOverRegionResponse(10,
                new RegionData()
                        .setLatitudeMax(latitudeMax)
                        .setLatitudeMin(latitudeMin)
                        .setLongitudeMax(longitudeMax)
                        .setLongitudeMin(longitudeMin),
                regionName);
        given(skyDataService.getFlightsOverRegion(regionName)).willReturn(Mono.just(flightsOverRegionResponse));
        client.get()
                .uri("/flightsOverRegion/"+regionName)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(FlightsOverRegionResponse.class)
                .isEqualTo(flightsOverRegionResponse);
    }

    @Test
    public void whenAddRegion_thenRegionIsAdded() {

        String regionName = "Netherlands";
        Double latitudeMax = 47.8229;
        Double latitudeMin = 5.9962;
        Double longitudeMax = 10.5226;
        Double longitudeMin = 5.9962;

        AddRegionRequest addRegionRequest = new AddRegionRequest();
        addRegionRequest.setLatitudeMax(latitudeMax);
        addRegionRequest.setLatitudeMin(latitudeMin);
        addRegionRequest.setLongitudeMax(longitudeMax);
        addRegionRequest.setLongitudeMin(longitudeMin);
        addRegionRequest.setRegionName(regionName);
        AddRegionResponse addRegionResponse = new AddRegionResponse(Constants.REGION_ADDED,
                regionName,
                new RegionData()
                        .setLatitudeMax(latitudeMax)
                        .setLatitudeMin(latitudeMin)
                        .setLongitudeMax(longitudeMax)
                        .setLongitudeMin(longitudeMin));

        given(skyDataService.addRegion(addRegionRequest)).willReturn(addRegionResponse);

        client.put()
                .uri("/addRegion")
                .body(Mono.just(addRegionRequest), AddRegionRequest.class)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(AddRegionResponse.class)
                .isEqualTo(addRegionResponse);
    }


    @Test
    public void whenGetFlightData_thenFlightDataReturned() {


        FlightDataPoint flightDataPoint1 = new FlightDataPoint("4b1808", "SWR109A", "Switzerland", 1644518185D, 1644518185D, 8.5575, 47.4559, null, true, 0D, 5.62, null, null, null, "1102", false, PositionSource.ADS_B, 0);
        FlightDataPoint flightDataPoint2 = new FlightDataPoint("3c65c3", "DLH9JF", "Germany", 1644518192D, 1644518192D, 9.291, 45.8847, 11590.02, false, 218.83, 328.07, 0D, null, 11681.46, "1000", false, PositionSource.ADS_B, 4);
        FlightData flightData = new FlightData(1644518192, Arrays.asList(flightDataPoint1, flightDataPoint2));

        given(skyDataService.getData()).willReturn(Mono.just(flightData));

        client.get()
                .uri("/flightState")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(FlightData.class)
                .isEqualTo(flightData);
    }

}
