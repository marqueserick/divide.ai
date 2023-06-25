package com.emtech.divideAi.service;

import com.emtech.divideAi.factory.UsuarioFactory;
import com.emtech.divideAi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceLocator {

    private static UsuarioRepository usuarioRepository;
    private static UsuarioFactory usuarioFactory;

    public ServiceLocator(UsuarioRepository usuarioRepository, UsuarioFactory usuarioFactory){
        this.usuarioRepository = usuarioRepository;
        this.usuarioFactory = usuarioFactory;
    }

    public static UsuarioService getUsuarioService(){
        return new UsuarioService(usuarioRepository, usuarioFactory);
    }
}
