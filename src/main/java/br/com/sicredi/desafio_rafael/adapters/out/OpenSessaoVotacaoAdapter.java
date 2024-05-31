package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.SessaoVotacaoRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.SessaoVotacaoMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.OpenSessaoVotacaoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpenSessaoVotacaoAdapter implements OpenSessaoVotacaoOutputPort {
    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private SessaoVotacaoMapper sessaoVotacaoMapper;

    @Override
    public void open(SessaoVotacao sessaoVotacao) {
        var sessaoVotacaoEntity = sessaoVotacaoMapper.toSessaoVotacaoEntity(sessaoVotacao);
        System.out.println(sessaoVotacaoEntity.mostrar());
        sessaoVotacaoRepository.insert(sessaoVotacaoEntity);
    }
}
