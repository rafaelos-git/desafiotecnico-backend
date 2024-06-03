package br.com.sicredi.desafio_rafael.application.core.domain;

import org.springframework.data.annotation.Id;

public class Voto {
    @Id
    private String id;
    private String pautaId;
    private String cpfAssociado;
    private String voto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPautaId() {
        return pautaId;
    }

    public void setPautaId(String pautaId) {
        this.pautaId = pautaId;
    }

    public String getCpfAssociado() {
        return cpfAssociado;
    }

    public void setCpfAssociado(String cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"pautaId\": \"" + pautaId + "\"," +
                "\"cpfAssociado\": \"" + cpfAssociado + "\"," +
                "\"voto\": \"" + voto + "\"" +
                "}";
    }
}
