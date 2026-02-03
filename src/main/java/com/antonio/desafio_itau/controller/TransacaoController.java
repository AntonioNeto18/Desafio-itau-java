package com.antonio.desafio_itau.controller;

import com.antonio.desafio_itau.dto.TransacaoRequest;
import com.antonio.desafio_itau.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping
    public ResponseEntity<Void> registrarTransacao(@RequestBody TransacaoRequest request){
        service.registrarTransacao(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
