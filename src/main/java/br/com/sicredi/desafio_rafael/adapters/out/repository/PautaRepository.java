package br.com.sicredi.desafio_rafael.adapters.out.repository;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.PautaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PautaRepository extends MongoRepository<PautaEntity, String> {
}
