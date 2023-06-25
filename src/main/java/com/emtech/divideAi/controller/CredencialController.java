package com.emtech.divideAi.controller;

import com.emtech.divideAi.dto.CredencialDto;
import com.emtech.divideAi.service.CredencialService;
import com.emtech.divideAi.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class CredencialController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CredencialService service;

    @PostMapping
    public ResponseEntity<String> autenticar(@RequestBody @Valid CredencialDto dto){
        return autenticar(dto.getEmail(), dto.getSenha());
    }

    @PostMapping("/novo")
    public ResponseEntity<String> salvar(@RequestBody CredencialDto dto){
        service.salvar(dto);
        return autenticar(dto.getEmail(), dto.getSenha());

    }

    private ResponseEntity<String> autenticar(String email, String senha) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, senha);
        Authentication auth = authManager.authenticate(authToken);
        String token = tokenService.gerarToken(auth);
        return ResponseEntity.ok(token);
    }
}
