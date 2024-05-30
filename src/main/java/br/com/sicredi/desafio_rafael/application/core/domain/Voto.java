package br.com.sicredi.desafio_rafael.application.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Voto {
    @Id
    private String id;
    @DBRef
    private SessaoVotacao sessaoVotacao;
    private String associadoId;
    private boolean voto;

    public String getIdAssociado() {
        return associadoId;
    }

    public void setIdAssociado(String associadoId) {
        this.associadoId = associadoId;
    }

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }
}
