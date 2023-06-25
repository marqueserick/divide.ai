package com.emtech.divideAi.dominio;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String identificador;

    private String nome;

    @Setter
    private Boolean isMestre;

    @OneToMany(mappedBy = "proprietario")
    private List<Cartao> cartoes = new ArrayList<>();
}
