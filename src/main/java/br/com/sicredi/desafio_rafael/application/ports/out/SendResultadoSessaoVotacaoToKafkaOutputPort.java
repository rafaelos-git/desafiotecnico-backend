package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;

public interface SendResultadoSessaoVotacaoToKafkaOutputPort {
    void send(SessaoVotacao sessaoVotacao);
}
