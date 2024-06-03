package br.com.sicredi.desafio_rafael.application.ports.in;

import br.com.sicredi.desafio_rafael.application.core.domain.ResultadoVotacao;

public interface CountVotosInputPort {
    ResultadoVotacao count(String pautaId);
}
