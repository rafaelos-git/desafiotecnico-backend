package br.com.sicredi.desafio_rafael.application.core.usecase;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.PautaEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;
import br.com.sicredi.desafio_rafael.application.ports.in.InsertPautaInputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.InsertPautaOutputPort;

public class InsertPautaUseCase implements InsertPautaInputPort {
    private final InsertPautaOutputPort insertPautaOutputPort;

    public InsertPautaUseCase(InsertPautaOutputPort insertPautaOutputPort) {
        this.insertPautaOutputPort = insertPautaOutputPort;
    }

    @Override
    public PautaEntity insert(Pauta pauta) {
        return insertPautaOutputPort.insert(pauta);
    }
}
