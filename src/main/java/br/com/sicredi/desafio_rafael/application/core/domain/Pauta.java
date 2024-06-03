package br.com.sicredi.desafio_rafael.application.core.domain;

public class Pauta {
    private String id;
    private String nome;
    private String descricao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"nome\": \"" + nome + "\"," +
                "\"descricao\": \"" + descricao + "\"" +
                "}";
    }
}
