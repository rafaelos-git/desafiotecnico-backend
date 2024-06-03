package br.com.sicredi.desafio_rafael.application.core.usecase;

import br.com.sicredi.desafio_rafael.application.core.domain.Voto;
import br.com.sicredi.desafio_rafael.application.ports.in.SendVotoInputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.*;

import java.util.Objects;

public class SendVotoUseCase implements SendVotoInputPort {
    private final FindSessaoVotacaoByIdOutputPort findSessaoVotacaoByIdOutputPort;
    private final VerifyVotoByAssociadoOutputPort verifyVotoByAssociadoOutputPort;
    private final SendVotoOutputPort sendVotoOutputPort;
    private final UpdateSessaoVotacaoOutputPort updateSessaoVotacaoOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public SendVotoUseCase(
            FindSessaoVotacaoByIdOutputPort findSessaoVotacaoByIdOutputPort,
            VerifyVotoByAssociadoOutputPort verifyVotoByAssociadoOutputPort,
            SendVotoOutputPort sendVotoOutputPort,
            UpdateSessaoVotacaoOutputPort updateSessaoVotacaoOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort
    ) {
        this.findSessaoVotacaoByIdOutputPort = findSessaoVotacaoByIdOutputPort;
        this.verifyVotoByAssociadoOutputPort = verifyVotoByAssociadoOutputPort;
        this.sendVotoOutputPort = sendVotoOutputPort;
        this.updateSessaoVotacaoOutputPort = updateSessaoVotacaoOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void send(String sessaoId, String cpfAssociado, String voto) {
        var sessaoVotacao = findSessaoVotacaoByIdOutputPort
                .find(sessaoId)
                .orElseThrow(() -> new RuntimeException("Sessao de votaçao nao encontrada"));
        if (sessaoVotacao.isEncerrada()) {
            throw new RuntimeException("A sessao de votação esta encerrada");
        }
        if (verifyVotoByAssociadoOutputPort.find(sessaoVotacao.getPauta().getId(), cpfAssociado)) {
            throw new RuntimeException("Associado ja votou nesta pauta");
        }
//        if (Objects.equals(sendCpfForValidationOutputPort.send(cpfAssociado), "UNABLE_TO_VOTE")) {
//            throw new RuntimeException("Associado nao pode votar");
//        }
        Voto novoVoto = new Voto();
        novoVoto.setPautaId(sessaoVotacao.getPauta().getId());
        novoVoto.setCpfAssociado(cpfAssociado);
        novoVoto.setVoto(voto);
        sessaoVotacao.getVotos().add(novoVoto);
        sendVotoOutputPort.send(novoVoto);
        updateSessaoVotacaoOutputPort.update(sessaoVotacao);
    }
}
