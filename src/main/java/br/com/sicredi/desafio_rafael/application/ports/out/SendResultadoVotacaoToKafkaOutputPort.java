package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.ResultadoVotacao;

public interface SendResultadoVotacaoToKafkaOutputPort {
    void send(ResultadoVotacao resultadoVotacao);
}
