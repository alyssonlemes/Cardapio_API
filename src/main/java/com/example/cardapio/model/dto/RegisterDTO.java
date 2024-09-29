package com.example.cardapio.model.dto;

import com.example.cardapio.model.entity.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
