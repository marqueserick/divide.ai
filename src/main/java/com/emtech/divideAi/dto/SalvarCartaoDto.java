package com.emtech.divideAi.dto;

import com.emtech.divideAi.dominio.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalvarCartaoDto {

    @JsonProperty("usuario")
    private String identificadorUsuario;
    private String nome;
    private String digitos;
    private Integer vencimentoFatura;

    @Setter
    @JsonIgnore
    private Usuario proprietario;
}
