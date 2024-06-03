package br.com.sicredi.desafio_rafael.config;

import br.com.sicredi.desafio_rafael.adapters.out.CountVotosAdapter;
import br.com.sicredi.desafio_rafael.application.core.usecase.CountVotosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountVotosConfig {
    @Bean
    public CountVotosUseCase countVotosUseCase(
            CountVotosAdapter countVotosAdapter
    ) {
        return new CountVotosUseCase(countVotosAdapter);
    }
}
