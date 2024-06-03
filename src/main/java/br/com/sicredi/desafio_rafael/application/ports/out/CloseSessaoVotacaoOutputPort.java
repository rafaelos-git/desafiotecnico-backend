package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;

public interface CloseSessaoVotacaoOutputPort {
    void close(SessaoVotacao sessaoVotacao);
}
