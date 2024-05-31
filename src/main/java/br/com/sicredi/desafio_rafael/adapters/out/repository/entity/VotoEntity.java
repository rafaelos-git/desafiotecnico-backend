package br.com.sicredi.desafio_rafael.adapters.out.repository.entity;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "votos")
public class VotoEntity {
    @Id
    private String id;
    private SessaoVotacao sessaoVotacao;
    private String cpfAssociado;
    private String voto;
}
