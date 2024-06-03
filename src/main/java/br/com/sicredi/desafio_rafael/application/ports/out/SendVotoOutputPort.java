package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.Voto;

public interface SendVotoOutputPort {
    void send(Voto voto);
}
