package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.SessaoVotacaoRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.SessaoVotacaoEntityMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.UpdateSessaoVotacaoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateSessaoVotacaoAdapter implements UpdateSessaoVotacaoOutputPort {
    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private SessaoVotacaoEntityMapper sessaoVotacaoEntityMapper;

    @Override
    public void update(SessaoVotacao sessaoVotacao) {
        var sessaoVotacaoEntity = sessaoVotacaoEntityMapper.toSessaoVotacaoEntity(sessaoVotacao);
        sessaoVotacaoRepository.save(sessaoVotacaoEntity);
    }
}
