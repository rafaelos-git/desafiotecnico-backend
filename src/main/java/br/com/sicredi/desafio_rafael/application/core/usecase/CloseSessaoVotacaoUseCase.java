package br.com.sicredi.desafio_rafael.application.core.usecase;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.CloseSessaoVotacaoOutputPort;
import br.com.sicredi.desafio_rafael.application.ports.out.FindSessoesExpiradasOutputPort;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

public class CloseSessaoVotacaoUseCase {
    private final FindSessoesExpiradasOutputPort findSessoesExpiradasOutputPort;
    private final CloseSessaoVotacaoOutputPort closeSessaoVotacaoOutputPort;

    public CloseSessaoVotacaoUseCase(FindSessoesExpiradasOutputPort findSessoesExpiradasOutputPort, CloseSessaoVotacaoOutputPort closeSessaoVotacaoOutputPort) {
        this.findSessoesExpiradasOutputPort = findSessoesExpiradasOutputPort;
        this.closeSessaoVotacaoOutputPort = closeSessaoVotacaoOutputPort;
    }

    @Scheduled(fixedRate = 60000)
    public void close() {
        var sessoesExpiradas = findSessoesExpiradasOutputPort.find(LocalDateTime.now());
        sessoesExpiradas.ifPresent(sessoes -> {
            for(SessaoVotacao sessao : sessoes) {
                closeSessaoVotacaoOutputPort.close(sessao);
            }
        });
    }
}
