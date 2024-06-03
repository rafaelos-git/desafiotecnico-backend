package br.com.sicredi.desafio_rafael.application.core.usecase;

import br.com.sicredi.desafio_rafael.application.core.domain.ResultadoVotacao;
import br.com.sicredi.desafio_rafael.application.core.domain.Voto;
import br.com.sicredi.desafio_rafael.application.ports.in.CountVotosInputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.CountVotosOutputPort;

import java.util.List;

public class CountVotosUseCase implements CountVotosInputPort {
    private final CountVotosOutputPort countVotosOutputPort;

    public CountVotosUseCase(CountVotosOutputPort countVotosOutputPort) {
        this.countVotosOutputPort = countVotosOutputPort;
    }

    @Override
    public ResultadoVotacao count(String pautaId) {
        var votos = countVotosOutputPort.count(pautaId);
        int totalSim = 0;
        int totalNao = 0;

        if (votos.isPresent()) {
            List<Voto> sessoes = votos.get();
            totalSim = (int) sessoes
                    .stream()
                    .filter(voto -> "Sim".equalsIgnoreCase(voto.getVoto()))
                    .count();
            totalNao = (int) sessoes
                    .stream()
                    .filter(voto -> "Não".equalsIgnoreCase(voto.getVoto()))
                    .count();
        }

        ResultadoVotacao resultadoVotacao = new ResultadoVotacao();
        resultadoVotacao.setPautaId(pautaId);
        resultadoVotacao.setTotalSim(totalSim);
        resultadoVotacao.setTotalNao(totalNao);

        return resultadoVotacao;
    }
}
