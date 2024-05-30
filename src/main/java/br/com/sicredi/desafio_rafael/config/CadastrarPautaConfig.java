package br.com.sicredi.desafio_rafael.config;

import br.com.sicredi.desafio_rafael.adapters.out.CadastrarPautaAdapter;
import br.com.sicredi.desafio_rafael.application.core.usecase.CadastrarPautaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarPautaConfig {
    @Bean
    public CadastrarPautaUseCase cadastrarPautaUseCase(
            CadastrarPautaAdapter cadastrarPautaAdapter
    ) {
        return new CadastrarPautaUseCase(cadastrarPautaAdapter);
    }
}
