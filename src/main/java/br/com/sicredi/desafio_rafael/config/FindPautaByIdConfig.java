package br.com.sicredi.desafio_rafael.config;

import br.com.sicredi.desafio_rafael.adapters.out.FindPautaByIdAdapter;
import br.com.sicredi.desafio_rafael.application.core.usecase.FindPautaByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindPautaByIdConfig {
    @Bean
    public FindPautaByIdUseCase findPautaByIdUseCase(
            FindPautaByIdAdapter findPautaByIdAdapter
    ) {
        return new FindPautaByIdUseCase(findPautaByIdAdapter);
    }
}
