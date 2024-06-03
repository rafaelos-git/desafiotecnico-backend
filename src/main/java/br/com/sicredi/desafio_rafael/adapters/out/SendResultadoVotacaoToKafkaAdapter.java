package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.application.core.domain.ResultadoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.SendResultadoVotacaoToKafkaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendResultadoVotacaoToKafkaAdapter implements SendResultadoVotacaoToKafkaOutputPort {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(ResultadoVotacao resultadoVotacao) {
        kafkaTemplate.send("tp-resultado-sessoes-votacao", resultadoVotacao.toString());
    }
}
