package com.emtech.divideAi.factory;

import com.emtech.divideAi.dominio.Cartao;
import com.emtech.divideAi.dto.CartaoDto;
import com.emtech.divideAi.dto.SalvarCartaoDto;
import org.springframework.stereotype.Component;

@Component
public class CartaoFactory extends Factory<Cartao, CartaoDto, SalvarCartaoDto> {
    @Override
    public CartaoDto toDto(Cartao cartao) {
        return CartaoDto.builder()
                .id(cartao.getId())
                .nome(cartao.getNome())
                .digitos(cartao.getDigitos())
                .vencimentoFatura(cartao.getVencimentoFatura())
                .build();
    }

    @Override
    public Cartao toModel(SalvarCartaoDto dto) {
        return Cartao.builder()
                .nome(dto.getNome())
                .digitos(dto.getDigitos())
                .vencimentoFatura(dto.getVencimentoFatura())
                .proprietario(dto.getProprietario())
                .build();
    }
}
