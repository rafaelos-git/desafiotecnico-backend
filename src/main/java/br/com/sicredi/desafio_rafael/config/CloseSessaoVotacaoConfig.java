package br.com.sicredi.desafio_rafael.config;

import br.com.sicredi.desafio_rafael.adapters.out.CloseSessaoVotacaoAdapter;
import br.com.sicredi.desafio_rafael.adapters.out.FindSessoesExpiradasAdapter;
import br.com.sicredi.desafio_rafael.application.core.usecase.CloseSessaoVotacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class CloseSessaoVotacaoConfig {
    @Bean
    public CloseSessaoVotacaoUseCase closeSessaoVotacaoUseCase(
            FindSessoesExpiradasAdapter findSessoesExpiradasAdapter,
            CloseSessaoVotacaoAdapter closeSessaoVotacaoAdapter
    ) {
        return new CloseSessaoVotacaoUseCase(
                findSessoesExpiradasAdapter,
                closeSessaoVotacaoAdapter
        );
    }

}
