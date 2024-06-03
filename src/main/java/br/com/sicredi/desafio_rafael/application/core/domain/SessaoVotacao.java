package br.com.sicredi.desafio_rafael.application.core.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SessaoVotacao {
    private String id;
    private Pauta pauta;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private boolean encerrada;
    private List<Voto> votos;

    public SessaoVotacao(){}

    public SessaoVotacao(Pauta pauta, Integer duracaoEmMinutos) {
        this.pauta = pauta;
        this.dataInicio = LocalDateTime.now();
        this.dataFim = LocalDateTime.now().plusMinutes(duracaoEmMinutos != null ? duracaoEmMinutos : 1);
        this.encerrada = false;
        this.votos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isEncerrada() {
        return encerrada;
    }

    public void setEncerrada(boolean encerrada) {
        this.encerrada = encerrada;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"pauta\": \"" + pauta + "\"," +
                "\"dataInicio\": \"" + dataInicio + "\"," +
                "\"dataFim\": \"" + dataFim + "\"," +
                "\"encerrada\": " + encerrada + "," +
                "\"votos\": " + votos +
                "}";
    }
}
