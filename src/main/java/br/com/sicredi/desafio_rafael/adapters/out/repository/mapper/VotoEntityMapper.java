package br.com.sicredi.desafio_rafael.adapters.out.repository.mapper;

import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.VotoEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.Voto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotoEntityMapper {
    VotoEntity toVotoEntity(Voto voto);
}
