package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.SessaoVotacaoRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.SessaoVotacaoEntity;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.SessaoVotacaoEntityMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.OpenSessaoVotacaoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpenSessaoVotacaoAdapter implements OpenSessaoVotacaoOutputPort {
    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private SessaoVotacaoEntityMapper sessaoVotacaoEntityMapper;

    @Override
    public SessaoVotacaoEntity open(SessaoVotacao sessaoVotacao) {
        var sessaoVotacaoEntity = sessaoVotacaoEntityMapper.toSessaoVotacaoEntity(sessaoVotacao);
        return sessaoVotacaoRepository.insert(sessaoVotacaoEntity);
    }
}
