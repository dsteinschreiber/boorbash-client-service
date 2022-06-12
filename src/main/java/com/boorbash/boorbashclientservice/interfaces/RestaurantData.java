package com.boorbash.boorbashclientservice.interfaces;

import java.math.BigDecimal;

public class RestaurantData {
    private final String pictureUrl;
    private final String name;
    private final String description;
    private final BigDecimal rating;

    private RestaurantData(String pictureUrl, String name, String description, BigDecimal rating) {
        this.pictureUrl = pictureUrl;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public static RestaurantData of(String pictureUrl, String name, String description, BigDecimal rating){
        return new RestaurantData(pictureUrl, name, description, rating);
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getRating() {
        return rating;
    }
}
