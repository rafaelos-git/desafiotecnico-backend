package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.SendResultadoSessaoVotacaoToKafkaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendResultadoSessaoVotacaoToKafkaAdapter implements SendResultadoSessaoVotacaoToKafkaOutputPort {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(SessaoVotacao sessaoVotacao) {
        System.out.println(sessaoVotacao.toString());
        kafkaTemplate.send("tp-resultado-sessoes-votacao", sessaoVotacao.toString());
    }
}
