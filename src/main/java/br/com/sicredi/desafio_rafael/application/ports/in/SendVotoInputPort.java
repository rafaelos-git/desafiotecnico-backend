package br.com.sicredi.desafio_rafael.application.ports.in;

public interface SendVotoInputPort {
    void send(String sessaoId, String cpfAssociado, String voto);
}
