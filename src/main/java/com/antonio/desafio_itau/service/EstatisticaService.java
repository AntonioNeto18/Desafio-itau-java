package com.antonio.desafio_itau.service;

import com.antonio.desafio_itau.dto.EstatisticaResponse;
import com.antonio.desafio_itau.dto.TransacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;

@Service
public class EstatisticaService {

    @Autowired
    private TransacaoService transacaoService;

    // GET /estatistica
    public EstatisticaResponse gerarEstatistica(Integer segundos){
        var transacoes = transacaoService.listarUltimasTransacoes(segundos);

        if (transacoes.size() == 0){
            return new EstatisticaResponse(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics estatisticas = transacoes.stream()
                .mapToDouble(TransacaoRequest::valor)
                .summaryStatistics();

        return new EstatisticaResponse(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax()
        );
    }
}
