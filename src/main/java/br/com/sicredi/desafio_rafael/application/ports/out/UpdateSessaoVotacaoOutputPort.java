package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;

public interface UpdateSessaoVotacaoOutputPort {
    void update(SessaoVotacao sessaoVotacao);
}
