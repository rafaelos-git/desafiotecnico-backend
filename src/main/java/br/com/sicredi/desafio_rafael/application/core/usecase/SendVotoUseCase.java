package br.com.sicredi.desafio_rafael.application.core.usecase;

import br.com.sicredi.desafio_rafael.application.core.domain.Voto;
import br.com.sicredi.desafio_rafael.application.ports.in.SendVotoInputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.FindSessaoVotacaoByIdOutputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.UpdateSessaoVotacaoOutputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.VerifyVotoByAssociadoOutputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.SendVotoOutputPort;

public class SendVotoUseCase implements SendVotoInputPort {
    private final FindSessaoVotacaoByIdOutputPort findSessaoVotacaoByIdOutputPort;
    private final VerifyVotoByAssociadoOutputPort verifyVotoByAssociadoOutputPort;
    private final SendVotoOutputPort sendVotoOutputPort;
    private final UpdateSessaoVotacaoOutputPort updateSessaoVotacaoOutputPort;

    public SendVotoUseCase(
            FindSessaoVotacaoByIdOutputPort findSessaoVotacaoByIdOutputPort,
            VerifyVotoByAssociadoOutputPort verifyVotoByAssociadoOutputPort,
            SendVotoOutputPort sendVotoOutputPort,
            UpdateSessaoVotacaoOutputPort updateSessaoVotacaoOutputPort
    ) {
        this.findSessaoVotacaoByIdOutputPort = findSessaoVotacaoByIdOutputPort;
        this.verifyVotoByAssociadoOutputPort = verifyVotoByAssociadoOutputPort;
        this.sendVotoOutputPort = sendVotoOutputPort;
        this.updateSessaoVotacaoOutputPort = updateSessaoVotacaoOutputPort;
    }

    @Override
    public void send(String sessaoId, String cpfAssociado, String voto) {
        var sessaoVotacao = findSessaoVotacaoByIdOutputPort
                .find(sessaoId)
                .orElseThrow(() -> new RuntimeException("Sessão de votação não encontrada"));
        if (sessaoVotacao.isEncerrada()) {
            throw new RuntimeException("A sessão de votação está encerrada");
        }
        if (verifyVotoByAssociadoOutputPort.find(sessaoVotacao, cpfAssociado)) {
            throw new RuntimeException("Associado já votou nesta pauta");
        }
        Voto novoVoto = new Voto();
        novoVoto.setSessaoVotacao(sessaoVotacao);
        novoVoto.setCpfAssociado(cpfAssociado);
        novoVoto.setVoto(voto);
        sessaoVotacao.getVotos().add(novoVoto);
        sendVotoOutputPort.send(novoVoto);
        updateSessaoVotacaoOutputPort.update(sessaoVotacao);
    }
}
