package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.SessaoVotacaoRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.SessaoVotacaoEntityMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.FindSessoesExpiradasOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class FindSessoesExpiradasAdapter implements FindSessoesExpiradasOutputPort {
    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private SessaoVotacaoEntityMapper sessaoVotacaoEntityMapper;

    @Override
    public Optional<List<SessaoVotacao>> find(LocalDateTime now) {
        var sessoesExpiradasEntity = sessaoVotacaoRepository.findByEncerradaFalseAndDataFimBefore(now);
        var sessoesVotacaoList = sessoesExpiradasEntity
                .stream()
                .map(entity -> sessaoVotacaoEntityMapper.toSessaoVotacao(entity))
                .toList();
        return sessoesVotacaoList.isEmpty() ? Optional.empty() : Optional.of(sessoesVotacaoList);
    }
}
