package br.com.sicredi.desafio_rafael.adapters.out.repository;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.VotoEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotoRepository extends MongoRepository<VotoEntity, String> {
    boolean existsBySessaoIdAndCpfAssociado(String sessaoId, String cpfAssociado);
}
