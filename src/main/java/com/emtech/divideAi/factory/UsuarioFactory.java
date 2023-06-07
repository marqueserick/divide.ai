package com.emtech.divideAi.factory;

import com.emtech.divideAi.dominio.Usuario;
import com.emtech.divideAi.dto.SalvarUsuarioDto;
import com.emtech.divideAi.dto.UsuarioDto;
import org.springframework.stereotype.Component;

@Component
public class UsuarioFactory extends Factory<Usuario, UsuarioDto, SalvarUsuarioDto> {

    public Usuario toModel(SalvarUsuarioDto dto){
        return Usuario.builder()
                .nome(dto.getNome())
                .build();
    }

    public UsuarioDto toDto(Usuario usuario){
        return UsuarioDto.builder()
                .nome(usuario.getNome())
                .identificador(usuario.getIdentificador())
                .build();
    }
}
