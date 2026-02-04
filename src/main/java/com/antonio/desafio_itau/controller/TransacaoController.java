package com.antonio.desafio_itau.controller;

import com.antonio.desafio_itau.dto.TransacaoRequest;
import com.antonio.desafio_itau.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@Tag(name = "Transação", description = "Gerencia endpoints relacionados a transação.")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping
    @Operation(summary = "Registra transação", description = "Cria uma nova transação.")
    @ApiResponse(responseCode = "201")
    @ApiResponse(responseCode = "422")
    @ApiResponse(responseCode = "400")
    public ResponseEntity<Void> registrarTransacao(@RequestBody TransacaoRequest request){
        service.registrarTransacao(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @Operation(summary = "Limpar transações", description = "Apaga todas as transações.")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<Void> limparTransacoes(){
        service.limparTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
