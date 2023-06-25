package com.emtech.divideAi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDto {

    private Long id;
    private String nome;
    private String digitos;
    private Integer vencimentoFatura;
}
