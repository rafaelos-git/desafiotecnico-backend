package br.com.sicredi.desafio_rafael.adapters.out.repository.entity;

import br.com.sicredi.desafio_rafael.application.core.domain.Voto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "pautas")
public class PautaEntity {
    @Id
    private String id;
    private String nome;
    private String descricao;
}
