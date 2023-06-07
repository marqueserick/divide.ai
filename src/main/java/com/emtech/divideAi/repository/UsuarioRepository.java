package com.emtech.divideAi.repository;

import com.emtech.divideAi.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    default Usuario salvar(Usuario usuario){
        usuario.setIdentificador(UUID.randomUUID());
        this.save(usuario);
        return usuario;
    }
}
