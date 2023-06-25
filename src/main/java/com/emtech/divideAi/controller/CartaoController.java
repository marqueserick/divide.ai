package com.emtech.divideAi.controller;

import com.emtech.divideAi.dto.CartaoDto;
import com.emtech.divideAi.dto.SalvarCartaoDto;
import com.emtech.divideAi.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cartao")
public class CartaoController {

    @Autowired
    private CartaoService service;

    @PostMapping
    public CartaoDto salvar(@RequestBody SalvarCartaoDto dto){
        return service.salvar(dto);
    }
}
