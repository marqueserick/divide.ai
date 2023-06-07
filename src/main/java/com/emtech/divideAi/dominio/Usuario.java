package com.emtech.divideAi.dominio;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="usuario")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private UUID identificador;

    private String nome;

    private Boolean isMestre;

    @OneToMany
    private List<Cartao> cartoes;
}
