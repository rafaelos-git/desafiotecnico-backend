package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.SessaoVotacaoRepository;
import br.com.sicredi.desafio_rafael.adapters.out.repository.mapper.SessaoVotacaoMapper;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.FindSessoesExpiradasOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FindSessoesExpiradasAdapter implements FindSessoesExpiradasOutputPort {
    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private SessaoVotacaoMapper sessaoVotacaoMapper;

    @Override
    public Optional<List<SessaoVotacao>> find(LocalDateTime now) {
        var sessoesExpiradasEntity = sessaoVotacaoRepository.findByEncerradaFalseAndDataFimBefore(now);
        List<SessaoVotacao> sessoesVotacaoList = sessoesExpiradasEntity
                .stream()
                .map(entity -> sessaoVotacaoMapper.toSessaoVotacao(entity))
                .toList();
        return sessoesVotacaoList.isEmpty() ? Optional.empty() : Optional.of(sessoesVotacaoList);
    }
}
