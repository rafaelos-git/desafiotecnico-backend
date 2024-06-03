package br.com.sicredi.desafio_rafael.application.ports.out;

import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.core.domain.Voto;

public interface VerifyVotoByAssociadoOutputPort {
    boolean find(String pautaId, String cpfAssociado);
}
