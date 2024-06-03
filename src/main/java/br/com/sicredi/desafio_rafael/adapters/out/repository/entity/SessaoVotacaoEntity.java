package br.com.sicredi.desafio_rafael.adapters.out.repository.entity;

import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;
import br.com.sicredi.desafio_rafael.application.core.domain.Voto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "sessoes_votacao")
public class SessaoVotacaoEntity {
    @Id
    private String id;
    private Pauta pauta;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private boolean encerrada;
    private List<Voto> votos;
}
