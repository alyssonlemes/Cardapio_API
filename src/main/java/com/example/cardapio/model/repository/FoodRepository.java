package com.example.cardapio.model.repository;

import com.example.cardapio.model.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
