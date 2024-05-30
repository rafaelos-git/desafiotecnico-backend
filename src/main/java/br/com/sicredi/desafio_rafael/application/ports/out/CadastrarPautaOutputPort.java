package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;

public interface CadastrarPautaOutputPort {
    void cadastrar(Pauta pauta);
}
