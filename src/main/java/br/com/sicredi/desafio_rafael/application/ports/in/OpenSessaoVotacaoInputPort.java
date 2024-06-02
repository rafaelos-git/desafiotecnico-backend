package br.com.sicredi.desafio_rafael.application.ports.in;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.SessaoVotacaoEntity;

public interface OpenSessaoVotacaoInputPort {
    SessaoVotacaoEntity open(String pautaId, Integer duracaoEmMinutos);
}
