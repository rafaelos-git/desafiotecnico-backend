package br.com.sicredi.desafio_rafael.config;

import br.com.sicredi.desafio_rafael.adapters.out.InsertPautaAdapter;
import br.com.sicredi.desafio_rafael.application.core.usecase.InsertPautaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertPautaConfig {
    @Bean
    public InsertPautaUseCase cadastrarPautaUseCase(
            InsertPautaAdapter cadastrarPautaAdapter
    ) {
        return new InsertPautaUseCase(cadastrarPautaAdapter);
    }
}
