package br.com.sicredi.desafio_rafael.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pautas")
public class PautaEntity {
    @Id
    private String id;
    private String nome;
    private String descricao;
}
