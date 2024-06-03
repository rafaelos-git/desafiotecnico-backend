package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.SessaoVotacaoRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.SessaoVotacaoEntityMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.FindSessaoVotacaoByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindSessaoVotacaoByIdAdapter implements FindSessaoVotacaoByIdOutputPort {
    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private SessaoVotacaoEntityMapper sessaoVotacaoEntityMapper;

    @Override
    public Optional<SessaoVotacao> find(String id) {
        var sessaoVotacaoEntity = sessaoVotacaoRepository.findById(id);
        return sessaoVotacaoEntity.map(entity -> sessaoVotacaoEntityMapper.toSessaoVotacao(entity));
    }
}
