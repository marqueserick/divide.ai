package com.emtech.divideAi.service;

import com.emtech.divideAi.dominio.Cartao;
import com.emtech.divideAi.dto.CartaoDto;
import com.emtech.divideAi.dto.SalvarCartaoDto;
import com.emtech.divideAi.factory.CartaoFactory;
import com.emtech.divideAi.repository.CartaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartaoService {

    private CartaoRepository repository;
    private CartaoFactory factory;

    public CartaoService(CartaoRepository repository, CartaoFactory factory){
        this.repository = repository;
        this.factory = factory;
    }

    @Transactional
    public CartaoDto salvar(SalvarCartaoDto dto){
        dto.setProprietario(ServiceLocator.getUsuarioService().listar(dto.getIdentificadorUsuario()));
        Cartao cartao = factory.toModel(dto);
        repository.save(cartao);
        return factory.toDto(cartao);
    }
}
