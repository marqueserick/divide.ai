package com.emtech.divideAi.controller;

import com.emtech.divideAi.dto.SalvarUsuarioDto;
import com.emtech.divideAi.dto.UsuarioDto;
import com.emtech.divideAi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public UsuarioDto salvar(@RequestBody SalvarUsuarioDto dto){
        return service.salvar(dto);
    }
}
