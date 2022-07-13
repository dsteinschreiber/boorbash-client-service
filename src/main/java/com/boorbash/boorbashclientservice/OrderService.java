package com.boorbash.boorbashclientservice;

import com.boorbash.interfaces.menu.Menu;
import com.boorbash.interfaces.menu.MenuDivision;
import com.boorbash.interfaces.menu.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@RestController
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    private WebClient webClient = WebClient.create("http://localhost:8082");

    @GetMapping("getMenu")
    public Menu getMenu(@RequestParam("restaurantId") int restaurantId) throws SQLException {
        LOGGER.debug("Searching restaurant ID: " + restaurantId);

        return this.webClient.get()
                .uri(x -> x
                        .path("/getMenu")
                        .queryParam("restaurantId", restaurantId)
                        .build())
                .retrieve()
                .bodyToMono(Menu.class)
                .block();
    }

}
