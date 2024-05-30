package br.com.sicredi.desafio_rafael.application.core.domain;

public class Voto {
    private Long idAssociado;
    private boolean voto;

    public Long getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(Long idAssociado) {
        this.idAssociado = idAssociado;
    }

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }
}
