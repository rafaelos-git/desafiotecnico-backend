package br.com.sicredi.desafio_rafael.application.core.usecase;

import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;
import br.com.sicredi.desafio_rafael.application.ports.in.FindPautaByIdInputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.FindPautaByIdOutputPort;

import java.util.Optional;

public class FindPautaByIdUseCase implements FindPautaByIdInputPort {
    private final FindPautaByIdOutputPort findPautaByIdOutputPort;

    public FindPautaByIdUseCase(FindPautaByIdOutputPort findPautaByIdOutputPort) {
        this.findPautaByIdOutputPort = findPautaByIdOutputPort;
    }

    @Override
    public Pauta find(String id) {
        return findPautaByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Pauta nao encontrada!"));
    }
}
