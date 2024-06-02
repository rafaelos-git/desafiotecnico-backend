package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.PautaEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;

public interface InsertPautaOutputPort {
    PautaEntity insert(Pauta pauta);
}
