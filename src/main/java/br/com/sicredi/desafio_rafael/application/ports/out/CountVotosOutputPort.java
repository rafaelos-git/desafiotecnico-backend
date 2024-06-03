package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.Voto;

import java.util.List;
import java.util.Optional;

public interface CountVotosOutputPort {
    Optional<List<Voto>> count(String pautaId);
}
