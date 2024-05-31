package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.SessaoVotacaoRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.SessaoVotacaoMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.CloseSessaoVotacaoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CloseSessaoVotacaoAdapter implements CloseSessaoVotacaoOutputPort {
    @Autowired
    private SessaoVotacaoMapper sessaoVotacaoMapper;

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Override
    public void close(SessaoVotacao sessaoVotacao) {
        sessaoVotacao.setEncerrada(true);
        var sessaoVotacaoEntity = sessaoVotacaoMapper.toSessaoVotacaoEntity(sessaoVotacao);
        sessaoVotacaoRepository.save(sessaoVotacaoEntity);
    }
}
