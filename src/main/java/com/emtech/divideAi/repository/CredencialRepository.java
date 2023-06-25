package com.emtech.divideAi.repository;

import com.emtech.divideAi.dominio.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface CredencialRepository extends JpaRepository<Credencial, Long> {

    Optional<UserDetails> findByUsername(String username);
}
