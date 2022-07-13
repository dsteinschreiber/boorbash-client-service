package com.boorbash.boorbashclientservice;

import com.boorbash.interfaces.RestaurantData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@RestController
public class SearchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchService.class);

    private WebClient webClient = WebClient.create("http://localhost:8081");

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
