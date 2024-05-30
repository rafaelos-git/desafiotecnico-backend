package br.com.sicredi.desafio_rafael.adapters.in.controller;

import br.com.sicredi.desafio_rafael.adapters.in.controller.mapper.PautaMapper;
import br.com.sicredi.desafio_rafael.adapters.in.controller.request.PautaRequest;
import br.com.sicredi.desafio_rafael.application.ports.in.CadastrarPautaInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {
    @Autowired
    private CadastrarPautaInputPort cadastrarPautaInputPort;

    @Autowired
    private PautaMapper pautaMapper;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody PautaRequest pautaRequest) {
        var pauta = pautaMapper.toPauta(pautaRequest);
        cadastrarPautaInputPort.cadastrar(pauta);
        return ResponseEntity.ok().build();
    }
}
