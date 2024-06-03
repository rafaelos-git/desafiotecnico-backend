package br.com.sicredi.desafio_rafael.application.core.domain;

public class ResultadoVotacao {
    private String pautaId;
    private Integer totalSim;
    private Integer totalNao;

    public String getPautaId() {
        return pautaId;
    }

    public void setPautaId(String pautaId) {
        this.pautaId = pautaId;
    }

    public Integer getTotalSim() {
        return totalSim;
    }

    public void setTotalSim(Integer totalSim) {
        this.totalSim = totalSim;
    }

    public Integer getTotalNao() {
        return totalNao;
    }

    public void setTotalNao(Integer totalNao) {
        this.totalNao = totalNao;
    }

    @Override
    public String toString() {
        return "{" +
                "\"pautaId\": \"" + pautaId + "\"," +
                "\"totalSim\": " + totalSim + "," +
                "\"totalNao\": " + totalNao +
                "}";
    }
}
