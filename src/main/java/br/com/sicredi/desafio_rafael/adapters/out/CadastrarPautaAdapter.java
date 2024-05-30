package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.PautaRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.PautaEntityMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.Pauta;
import br.com.sicredi.desafio_rafael.application.ports.out.CadastrarPautaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastrarPautaAdapter implements CadastrarPautaOutputPort {
    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private PautaEntityMapper pautaEntityMapper;

    @Override
    public void cadastrar(Pauta pauta) {
        var pautaEntity = pautaEntityMapper.toPautaEntity(pauta);
        pautaRepository.insert(pautaEntity);
    }
}
