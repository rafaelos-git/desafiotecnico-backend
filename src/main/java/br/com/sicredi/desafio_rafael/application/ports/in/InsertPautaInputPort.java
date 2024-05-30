package br.com.sicredi.desafio_rafael.application.ports.in;

import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;

public interface InsertPautaInputPort {
    void insert(Pauta pauta);
}
