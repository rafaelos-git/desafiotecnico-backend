package br.com.sicredi.desafio_rafael.adapters.in.controller;

import br.com.sicredi.desafio_rafael.adapters.in.controller.request.SessaoVotacaoRequest;
import br.com.sicredi.desafio_rafael.application.ports.in.OpenSessaoVotacaoInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessoes")
public class SessaoVotacaoController {
    @Autowired
    private OpenSessaoVotacaoInputPort openSessaoVotacaoInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody SessaoVotacaoRequest sessaoVotacaoRequest) {
        openSessaoVotacaoInputPort.open(
                sessaoVotacaoRequest.getPautaId(),
                sessaoVotacaoRequest.getDuracaoEmMinutos()
        );
        return ResponseEntity.ok().build();
    }
}
