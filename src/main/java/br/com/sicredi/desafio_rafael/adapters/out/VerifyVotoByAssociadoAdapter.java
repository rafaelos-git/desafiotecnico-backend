package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.repository.VotoRepository;
import br.com.sicredi.desafio_rafael.application.core.domain.SessaoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.out.VerifyVotoByAssociadoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerifyVotoByAssociadoAdapter implements VerifyVotoByAssociadoOutputPort {
    @Autowired
    private VotoRepository votoRepository;

    @Override
    public boolean find(SessaoVotacao sessaoVotacao, String cpfAssociado) {
        return votoRepository.existsBySessaoVotacaoAndCpfAssociado(sessaoVotacao, cpfAssociado);
    }
}
