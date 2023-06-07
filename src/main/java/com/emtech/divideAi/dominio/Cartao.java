package com.emtech.divideAi.dominio;

import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cartao")
@Getter
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID identificador;
    private String nome;

    @Column(length = 4)
    private String digitos;

    private Integer vencimentoFatura;

    @ManyToOne
    private Usuario proprietario;
}
