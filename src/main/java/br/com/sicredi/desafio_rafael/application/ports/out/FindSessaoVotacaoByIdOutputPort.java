package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;

import java.util.Optional;

public interface FindSessaoVotacaoByIdOutputPort {
    Optional<SessaoVotacao> find(String id);
}
