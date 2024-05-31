package br.com.sicredi.desafio_rafael.application.ports.in;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;

public interface OpenSessaoVotacaoInputPort {
    void open(String pautaId, Integer duracaoEmMinutos);
}
