package com.emtech.divideAi.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cartao")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(length = 4)
    private String digitos;

    private Integer vencimentoFatura;

    @ManyToOne
    @JoinColumn(name = "proprietario", nullable = false)
    private Usuario proprietario;
}
