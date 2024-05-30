package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.PautaRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.PautaEntityMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;
import br.com.sicredi.desafio_rafael.application.ports.out.InsertPautaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertPautaAdapter implements InsertPautaOutputPort {
    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private PautaEntityMapper pautaEntityMapper;

    @Override
    public void insert(Pauta pauta) {
        var pautaEntity = pautaEntityMapper.toPautaEntity(pauta);
        pautaRepository.insert(pautaEntity);
    }
}
