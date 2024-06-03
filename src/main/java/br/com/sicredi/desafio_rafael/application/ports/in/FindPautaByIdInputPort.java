package br.com.sicredi.desafio_rafael.application.ports.in;

import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;

import java.util.Optional;

public interface FindPautaByIdInputPort {
    Pauta find(String id);
}
