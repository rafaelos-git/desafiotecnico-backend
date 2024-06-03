package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.VotoRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.VotoEntityMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.Voto;
import br.com.sicredi.desafio_rafael.application.ports.out.CountVotosOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountVotosAdapter implements CountVotosOutputPort {
    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private VotoEntityMapper votoEntityMapper;

    @Override
    public Optional<List<Voto>> count(String pautaId) {
        var votosEntity = votoRepository.findByPautaId(pautaId);
        var votosList = votosEntity
                .stream()
                .map(entity -> votoEntityMapper.toVoto(entity))
                .toList();
        return votosList.isEmpty() ? Optional.empty() : Optional.of(votosList);
    }
}
