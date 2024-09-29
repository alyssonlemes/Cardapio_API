package com.example.cardapio.model.repository;

import com.example.cardapio.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {
    //método para consultar usuário por email e retorna um User Details
     User findByLogin(String login);
}
