package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;

public interface OpenSessaoVotacaoOutputPort {
    void open(SessaoVotacao sessaoVotacao);
}
