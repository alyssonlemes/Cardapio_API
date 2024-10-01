package com.example.cardapio.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.cardapio.model.entity.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value(("${api.security.token.secret}"))
    private String secret;

    public String generateToken(User user){

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret); //Definindo secret para deixar tokens unicos para nossa aplicação
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(genExpirationDate()) //tempo de expiração
                    .sign(algorithm); //faz a assinatura

            return token;

        } catch (JWTCreationException exception){
            throw new RuntimeException("Error while generating token", exception);
        }


    }
    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
