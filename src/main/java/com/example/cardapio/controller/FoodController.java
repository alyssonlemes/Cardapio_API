package com.example.cardapio.controller;

import com.example.cardapio.model.dto.FoodRequestDTO;
import com.example.cardapio.model.dto.FoodResponseDTO;
import com.example.cardapio.model.entity.Food;
import com.example.cardapio.model.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        //transformando DTO na entidade
        Food foodData = new Food(data);
        repository.save(foodData);
        return;

    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){
        //transformando entidade no DTO
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
