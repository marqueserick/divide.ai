package com.emtech.divideAi.service;

import com.emtech.divideAi.dominio.Usuario;
import com.emtech.divideAi.dto.SalvarUsuarioDto;
import com.emtech.divideAi.dto.UsuarioDto;
import com.emtech.divideAi.factory.UsuarioFactory;
import com.emtech.divideAi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    private UsuarioFactory factory;

    public UsuarioService(UsuarioRepository repository, UsuarioFactory factory){
        this.repository = repository;
        this.factory = factory;
    }

    public UsuarioDto salvar(SalvarUsuarioDto dto){

        Usuario usuario = factory.toModel(dto);
        repository.salvar(usuario);
        return factory.toDto(usuario);
    }

    public Usuario listar(String identificador) {
        return repository.findByIdentificador(identificador).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado"));
    }
}
