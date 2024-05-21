package com.example.cardapio.model.dto;

import com.example.cardapio.model.entity.Food;

public record FoodResponseDTO (Long id, String title, String image, Integer price){

    public FoodResponseDTO (Food food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
