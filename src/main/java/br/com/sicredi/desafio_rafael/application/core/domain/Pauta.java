package br.com.sicredi.desafio_rafael.application.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Pauta {
    private String id;
    private String descricao;
    private List<Voto> votos;

    public Pauta() {
        this.votos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
}
