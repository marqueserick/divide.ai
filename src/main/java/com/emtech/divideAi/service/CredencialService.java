package com.emtech.divideAi.service;

import com.emtech.divideAi.dominio.Credencial;
import com.emtech.divideAi.dto.CredencialDto;
import com.emtech.divideAi.factory.CredencialFactory;
import com.emtech.divideAi.repository.CredencialRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CredencialService implements UserDetailsService {

    private CredencialRepository repository;

    private CredencialFactory factory;

    public CredencialService(CredencialRepository repository, CredencialFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
    }

    @Transactional
    public void salvar(CredencialDto dto) {
        Credencial credencial = factory.toModel(dto);
        credencial.setUsuario(ServiceLocator.getUsuarioService().listar(dto.getIdentificador()));
        repository.save(credencial);
    }
}
