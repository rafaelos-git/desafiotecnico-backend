package br.com.sicredi.desafio_rafael.application.ports.in;

import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;

public interface CadastrarPautaInputPort {
    void cadastrar(Pauta pauta);
}
