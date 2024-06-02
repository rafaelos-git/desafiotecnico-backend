package br.com.sicredi.desafio_rafael.application.core.usecase;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.SessaoVotacaoEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.in.FindPautaByIdInputPort;
import br.com.sicredi.desafio_rafael.application.ports.in.OpenSessaoVotacaoInputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.OpenSessaoVotacaoOutputPort;

public class OpenSessaoVotacaoUseCase implements OpenSessaoVotacaoInputPort {
    private final FindPautaByIdInputPort findPautaByIdInputPort;
    private final OpenSessaoVotacaoOutputPort openSessaoVotacaoOutputPort;

    public OpenSessaoVotacaoUseCase(
            FindPautaByIdInputPort findPautaByIdInputPort,
            OpenSessaoVotacaoOutputPort openSessaoVotacaoOutputPort
    ) {
        this.findPautaByIdInputPort = findPautaByIdInputPort;
        this.openSessaoVotacaoOutputPort = openSessaoVotacaoOutputPort;
    }

    @Override
    public SessaoVotacaoEntity open(String pautaId, Integer duracaoEmMinutos) {
        var pauta = findPautaByIdInputPort.find(pautaId);
        SessaoVotacao sessaoVotacao = new SessaoVotacao(pauta, duracaoEmMinutos);
        return openSessaoVotacaoOutputPort.open(sessaoVotacao);
    }
}
