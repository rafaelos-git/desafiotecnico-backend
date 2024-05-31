package br.com.sicredi.desafio_rafael.config;

import br.com.sicredi.desafio_rafael.adapters.out.FindSessaoVotacaoByIdAdapter;
import br.com.sicredi.desafio_rafael.adapters.out.SendVotoAdapter;
import br.com.sicredi.desafio_rafael.adapters.out.UpdateSessaoVotacaoAdapter;
import br.com.sicredi.desafio_rafael.adapters.out.VerifyVotoByAssociadoAdapter;
import br.com.sicredi.desafio_rafael.application.core.usecase.SendVotoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendVotoConfig {
    @Bean
    public SendVotoUseCase sendVotoUseCase(
            FindSessaoVotacaoByIdAdapter findSessaoVotacaoByIdAdapter,
            VerifyVotoByAssociadoAdapter verifyVotoByAssociadoAdapter,
            SendVotoAdapter sendVotoAdapter,
            UpdateSessaoVotacaoAdapter updateSessaoVotacaoAdapter
    ) {
        return new SendVotoUseCase(
                findSessaoVotacaoByIdAdapter,
                verifyVotoByAssociadoAdapter,
                sendVotoAdapter,
                updateSessaoVotacaoAdapter
        );
    }
}
