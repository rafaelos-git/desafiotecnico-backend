package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FindSessoesExpiradasOutputPort {
    Optional<List<SessaoVotacao>> find(LocalDateTime now);
}
