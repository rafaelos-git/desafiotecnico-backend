package br.com.sicredi.desafio_rafael.adapters.out.repository.mapper;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.PautaEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PautaEntityMapper {
    PautaEntity toPautaEntity(Pauta pauta);
    Pauta toPauta(PautaEntity pauta);
}
