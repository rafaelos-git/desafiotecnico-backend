package br.com.sicredi.desafio_rafael.application.core.usecase;

import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;
import br.com.sicredi.desafio_rafael.application.ports.in.CadastrarPautaInputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.CadastrarPautaOutputPort;

public class CadastrarPautaUseCase implements CadastrarPautaInputPort {
    private final CadastrarPautaOutputPort cadastrarPautaOutputPort;

    public CadastrarPautaUseCase(CadastrarPautaOutputPort cadastrarPautaOutputPort) {
        this.cadastrarPautaOutputPort = cadastrarPautaOutputPort;
    }

    @Override
    public void cadastrar(Pauta pauta) {
        cadastrarPautaOutputPort.cadastrar(pauta);
    }
}
