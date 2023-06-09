package com.emtech.divideAi.repository;

import com.emtech.divideAi.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    default Usuario salvar(Usuario usuario){
        usuario.setIdentificador(UUID.randomUUID().toString());
        usuario.setIsMestre(false);
        this.save(usuario);
        return usuario;
    }

    Optional<Usuario> findByIdentificador(String identificador);
}
