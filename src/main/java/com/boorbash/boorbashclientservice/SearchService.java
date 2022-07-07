package com.boorbash.boorbashclientservice;

import com.boorbash.interfaces.RestaurantData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@RestController
public class SearchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchService.class);

    private WebClient webClient = WebClient.create("http://localhost:8081");

//    private static final List<RestaurantData> SAMPLE_RESULTS = Arrays.asList(
//            RestaurantData.of(
//                    "https://images.unsplash.com/photo-1572695157366-5e585ab2b69f?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwzfHxicnVzY2hldHRhfGVufDF8fHx8MTY1NDg5OTI2MA&ixlib=rb-1.2.1&q=80&w=200",
//                    "Little Italy",
//                    "Restaurant description for some italian restaurant",
//                    new BigDecimal("4.5")
//            ),
//            RestaurantData.of(
//                    "https://images.unsplash.com/photo-1565299507177-b0ac66763828?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMDUzMDJ8MHwxfHNlYXJjaHwzM3x8Zm9vZHxlbnwxfHx8fDE2NTQ4MjE1ODU&ixlib=rb-1.2.1&q=80&w=200",
//                    "Danny's Burgers",
//                    "Best burgers in town!",
//                    new BigDecimal("5.0")
//            )
//    );

    @GetMapping("restaurantSearch")
    public List<RestaurantData> restaurantSearch(@RequestParam("searchString") String searchString) {
        LOGGER.debug("Entering restaurant search " + searchString);

        return this.webClient.get()
                .uri(x -> x
                        .path("/restaurantSearch")
                        .queryParam("searchString", searchString)
                        .build())
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }

}
