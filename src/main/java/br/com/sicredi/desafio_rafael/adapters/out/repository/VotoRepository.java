package br.com.sicredi.desafio_rafael.adapters.out.repository;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.VotoEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VotoRepository extends MongoRepository<VotoEntity, String> {
    boolean existsByPautaIdAndCpfAssociado(String pautaId, String cpfAssociado);
    List<VotoEntity> findByPautaId(String pautaId);
}
