package com.antonio.desafio_itau.controller;

import com.antonio.desafio_itau.dto.EstatisticaResponse;
import com.antonio.desafio_itau.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaService service;

    @GetMapping
    public ResponseEntity<EstatisticaResponse> gerarEstatistica(@RequestParam(required = false, defaultValue = "60") Integer ultimosSegundos){
        return ResponseEntity.status(HttpStatus.OK).body(service.gerarEstatistica(ultimosSegundos));
    }
}
