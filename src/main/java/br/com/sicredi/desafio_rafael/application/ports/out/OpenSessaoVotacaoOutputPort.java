package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.SessaoVotacaoEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;

public interface OpenSessaoVotacaoOutputPort {
    SessaoVotacaoEntity open(SessaoVotacao sessaoVotacao);
}
