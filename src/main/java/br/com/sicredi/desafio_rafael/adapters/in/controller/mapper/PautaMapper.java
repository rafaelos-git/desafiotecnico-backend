package br.com.sicredi.desafio_rafael.adapters.in.controller.mapper;

import br.com.sicredi.desafio_rafael.adapters.in.controller.request.PautaRequest;
import br.com.sicredi.desafio_rafael.adapters.in.controller.response.PautaResponse;
import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PautaMapper {
    @Mapping(target = "id", ignore = true)
    Pauta toPauta(PautaRequest pautaRequest);
    PautaResponse toPautaResponse(Pauta pauta);
}
