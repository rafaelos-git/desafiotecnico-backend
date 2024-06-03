package br.com.sicredi.desafio_rafael.adapters.out.repository.mapper;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.SessaoVotacaoEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessaoVotacaoEntityMapper {
    SessaoVotacaoEntity toSessaoVotacaoEntity(SessaoVotacao sessaoVotacao);
    SessaoVotacao toSessaoVotacao(SessaoVotacaoEntity sessaoVotacaoEntity);
}
