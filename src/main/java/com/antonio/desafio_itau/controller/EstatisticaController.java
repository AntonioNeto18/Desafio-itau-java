package com.antonio.desafio_itau.controller;

import com.antonio.desafio_itau.dto.EstatisticaResponse;
import com.antonio.desafio_itau.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@Tag(name = "Estatística", description = "Gerencia endpoints relacionados a estatísticas.")
public class EstatisticaController {

    @Autowired
    private EstatisticaService service;

    @GetMapping
    @Operation(summary = "Gera estatísticas", description = "Gera estatísticas das transações.")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<EstatisticaResponse> gerarEstatistica(@RequestParam(required = false, defaultValue = "60") Integer ultimosSegundos){
        return ResponseEntity.status(HttpStatus.OK).body(service.gerarEstatistica(ultimosSegundos));
    }
}
