package com.emtech.divideAi.factory;

import com.emtech.divideAi.dominio.Credencial;
import com.emtech.divideAi.dto.CredencialDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CredencialFactory {

    public Credencial toModel(CredencialDto dto){
        return Credencial.builder()
                .password(new BCryptPasswordEncoder().encode(dto.getSenha()))
                .username(dto.getEmail())
                .build();
    }
}
