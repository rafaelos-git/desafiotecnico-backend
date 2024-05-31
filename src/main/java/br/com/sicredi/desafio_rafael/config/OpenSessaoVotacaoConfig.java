package br.com.sicredi.desafio_rafael.config;

import br.com.sicredi.desafio_rafael.adapters.out.OpenSessaoVotacaoAdapter;
import br.com.sicredi.desafio_rafael.application.core.usecase.FindPautaByIdUseCase;
import br.com.sicredi.desafio_rafael.application.core.usecase.OpenSessaoVotacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenSessaoVotacaoConfig {
    @Bean
    public OpenSessaoVotacaoUseCase openSessaoVotacaoUseCase(
            FindPautaByIdUseCase findPautaByIdUseCase,
            OpenSessaoVotacaoAdapter openSessaoVotacaoAdapter
    ) {
        return new OpenSessaoVotacaoUseCase(
                findPautaByIdUseCase,
                openSessaoVotacaoAdapter
        );
    }
}
