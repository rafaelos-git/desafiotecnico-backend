package br.com.sicredi.desafio_rafael.application.core.usecase;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.in.CountVotosInputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.CloseSessaoVotacaoOutputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.FindSessoesExpiradasOutputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.SendResultadoVotacaoToKafkaOutputPort;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

public class CloseSessaoVotacaoUseCase {
    private final FindSessoesExpiradasOutputPort findSessoesExpiradasOutputPort;
    private final CloseSessaoVotacaoOutputPort closeSessaoVotacaoOutputPort;
    private final SendResultadoVotacaoToKafkaOutputPort sendResultadoVotacaoToKafkaOutputPort;
    private final CountVotosInputPort countVotosInputPort;

    public CloseSessaoVotacaoUseCase(
            FindSessoesExpiradasOutputPort findSessoesExpiradasOutputPort,
            CloseSessaoVotacaoOutputPort closeSessaoVotacaoOutputPort,
            SendResultadoVotacaoToKafkaOutputPort sendResultadoVotacaoToKafkaOutputPort,
            CountVotosInputPort countVotosInputPort
    ) {
        this.findSessoesExpiradasOutputPort = findSessoesExpiradasOutputPort;
        this.closeSessaoVotacaoOutputPort = closeSessaoVotacaoOutputPort;
        this.sendResultadoVotacaoToKafkaOutputPort = sendResultadoVotacaoToKafkaOutputPort;
        this.countVotosInputPort = countVotosInputPort;
    }

    @Scheduled(fixedRate = 60000)
    public void close() {
        var sessoesExpiradas = findSessoesExpiradasOutputPort.find(LocalDateTime.now());
        sessoesExpiradas.ifPresent(sessoes -> {
            for(SessaoVotacao sessao : sessoes) {
                closeSessaoVotacaoOutputPort.close(sessao);
                sendResultadoVotacaoToKafkaOutputPort
                        .send(countVotosInputPort.count(sessao.getPauta().getId()));
            }
        });
    }
}
