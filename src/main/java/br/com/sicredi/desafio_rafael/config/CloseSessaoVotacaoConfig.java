package br.com.sicredi.desafio_rafael.config;

import br.com.sicredi.desafio_rafael.adapters.out.CloseSessaoVotacaoAdapter;
import br.com.sicredi.desafio_rafael.adapters.out.FindSessoesExpiradasAdapter;
import br.com.sicredi.desafio_rafael.adapters.out.SendResultadoVotacaoToKafkaAdapter;
import br.com.sicredi.desafio_rafael.application.core.usecase.CloseSessaoVotacaoUseCase;
import br.com.sicredi.desafio_rafael.application.core.usecase.CountVotosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class CloseSessaoVotacaoConfig {
    @Bean
    public CloseSessaoVotacaoUseCase closeSessaoVotacaoUseCase(
            FindSessoesExpiradasAdapter findSessoesExpiradasAdapter,
            CloseSessaoVotacaoAdapter closeSessaoVotacaoAdapter,
            SendResultadoVotacaoToKafkaAdapter sendResultadoVotacaoToKafkaAdapter,
            CountVotosUseCase countVotosUseCase
    ) {
        return new CloseSessaoVotacaoUseCase(
                findSessoesExpiradasAdapter,
                closeSessaoVotacaoAdapter,
                sendResultadoVotacaoToKafkaAdapter,
                countVotosUseCase
        );
    }

}
