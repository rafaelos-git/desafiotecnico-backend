package br.com.sicredi.desafio_rafael.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SessaoVotacaoRequest {
    @NotBlank
    private String pautaId;
    private Integer duracaoEmMinutos;
}
