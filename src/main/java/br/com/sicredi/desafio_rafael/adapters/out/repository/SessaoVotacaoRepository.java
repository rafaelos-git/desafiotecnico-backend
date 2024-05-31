package br.com.sicredi.desafio_rafael.adapters.out.repository;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.SessaoVotacaoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SessaoVotacaoRepository extends MongoRepository<SessaoVotacaoEntity, String> {
    List<SessaoVotacaoEntity> findByEncerradaFalseAndDataFimBefore(LocalDateTime now);
}
