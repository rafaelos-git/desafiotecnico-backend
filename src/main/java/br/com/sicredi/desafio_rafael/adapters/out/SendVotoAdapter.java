package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.VotoRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.VotoEntityMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.Voto;
import br.com.sicredi.desafio_rafael.application.ports.out.SendVotoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendVotoAdapter implements SendVotoOutputPort {
    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private VotoEntityMapper votoEntityMapper;

    @Override
    public void send(Voto voto) {
        var votoEntity = votoEntityMapper.toVotoEntity(voto);
        votoRepository.insert(votoEntity);
    }
}
