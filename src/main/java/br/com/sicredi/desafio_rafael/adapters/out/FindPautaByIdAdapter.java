package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.PautaRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.PautaEntityMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;
import br.com.sicredi.desafio_rafael.application.ports.out.FindPautaByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindPautaByIdAdapter implements FindPautaByIdOutputPort {
    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private PautaEntityMapper pautaEntityMapper;

    public Optional<Pauta> find(String id) {
        var pautaEntity = pautaRepository.findById(id);
        return pautaEntity.map(entity -> pautaEntityMapper.toPauta(entity));
    }
}
