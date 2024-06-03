package br.com.sicredi.desafio_rafael.application.ports.in;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.PautaEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;

public interface InsertPautaInputPort {
    PautaEntity insert(Pauta pauta);
}
