package br.com.sicredi.desafio_rafael.adapters.in.controller;

import br.com.sicredi.desafio_rafael.adapters.in.controller.mapper.PautaMapper;
import br.com.sicredi.desafio_rafael.adapters.in.controller.request.PautaRequest;
import br.com.sicredi.desafio_rafael.adapters.in.controller.response.PautaResponse;
import br.com.sicredi.desafio_rafael.adapters.out.repository.entity.PautaEntity;
import br.com.sicredi.desafio_rafael.application.core.domain.ResultadoVotacao;
import br.com.sicredi.desafio_rafael.application.ports.in.CountVotosInputPort;
import br.com.sicredi.desafio_rafael.application.ports.in.FindPautaByIdInputPort;
import br.com.sicredi.desafio_rafael.application.ports.in.InsertPautaInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {
    @Autowired
    private InsertPautaInputPort insertPautaInputPort;

    @Autowired
    private PautaMapper pautaMapper;

    @Autowired
    private FindPautaByIdInputPort findPautaByIdInputPort;

    @Autowired
    private CountVotosInputPort countVotosInputPort;

    @PostMapping
    public ResponseEntity<PautaEntity> insert(@Valid @RequestBody PautaRequest pautaRequest) {
        var pauta = pautaMapper.toPauta(pautaRequest);
        var pautaEntity = insertPautaInputPort.insert(pauta);
        return ResponseEntity.ok().body(pautaEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaResponse> findById(@PathVariable final String id) {
        var pauta = findPautaByIdInputPort.find(id);
        var pautaResponse = pautaMapper.toPautaResponse(pauta);
        return ResponseEntity.ok().body(pautaResponse);
    }

    @GetMapping("/{id}/resultado")
    public ResponseEntity<ResultadoVotacao> getResultado(@PathVariable final String id) {
        var resultado = countVotosInputPort.count(id);
        return ResponseEntity.ok().body(resultado);
    }
}
