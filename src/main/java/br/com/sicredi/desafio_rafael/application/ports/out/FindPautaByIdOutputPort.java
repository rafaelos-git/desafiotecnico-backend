package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;

import java.util.Optional;

public interface FindPautaByIdOutputPort {
    Optional<Pauta> find(String id);
}
