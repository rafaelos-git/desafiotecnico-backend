package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;

public interface InsertPautaOutputPort {
    void insert(Pauta pauta);
}
