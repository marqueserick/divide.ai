package com.emtech.divideAi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CredencialDto {

    private String identificador;
    private String email;
    private String senha;
}
