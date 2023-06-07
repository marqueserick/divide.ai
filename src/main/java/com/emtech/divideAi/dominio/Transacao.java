package com.emtech.divideAi.dominio;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="transacao")
@Getter
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(scale = 2)
    private BigDecimal valor;

    private LocalDate data;

    private String descricao;

    private Boolean emAberto;

    @ManyToOne
    private Cartao cartao;

    @ManyToOne
    private Usuario responsavelPagamento;
}
