package com.emtech.divideAi.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.token.secret}")
    private String secret;

    private static final String ISSUER_TOKEN= "Divide.ai";

    public String gerarToken(Authentication auth){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer(ISSUER_TOKEN)
                .withSubject(auth.getName())
                .withExpiresAt(obterPrazoExpiracao())
                .sign(algorithm);
    }
    public String obterUsuario(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
                .withIssuer(ISSUER_TOKEN)
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant obterPrazoExpiracao() {
        return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"));
    }
}
