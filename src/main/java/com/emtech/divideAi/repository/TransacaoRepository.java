package com.emtech.divideAi.repository;

import com.emtech.divideAi.dominio.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
