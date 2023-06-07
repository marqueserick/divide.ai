package com.emtech.divideAi.factory;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class Factory<Modelo, Dto, DtoSalvar> {

    abstract Dto toDto(Modelo modelo);
    abstract Modelo toModel(DtoSalvar dto);

    public List<Dto> toDto(List<Modelo> listaModelo){
        return listaModelo.stream().map(modelo -> toDto(modelo)).collect(Collectors.toList());
    }

}
