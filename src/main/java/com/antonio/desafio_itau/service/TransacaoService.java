package com.antonio.desafio_itau.service;

import com.antonio.desafio_itau.dto.TransacaoRequest;
import com.antonio.desafio_itau.exceptions.UnprocessableEntityException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<TransacaoRequest> transacoes = new ArrayList<>();

    // POST /transacao
    public void registrarTransacao(TransacaoRequest request){
        // Validando campos obrigatórios
        if (request.valor() == null || request.dataHora() == null){
            throw new UnprocessableEntityException();
        }

        // Validando dataHora
        if (request.dataHora().isAfter(OffsetDateTime.now())){
            throw new UnprocessableEntityException();
        }

        // Validando valor
        if (request.valor() < 0){
            throw new UnprocessableEntityException();
        }

        // Cria a transacao
        transacoes.add(request);
    }

    // DELETE /transacao
    public void limparTransacoes(){
        transacoes.clear();
    }

    // Lista as transacoes de um determinado periodo de tempo
    public List<TransacaoRequest> listarUltimasTransacoes(Integer segundos){
        return transacoes.stream()
                .filter(t -> t.dataHora().isAfter(OffsetDateTime.now().minusSeconds(segundos)))
                .toList();
    }
}
