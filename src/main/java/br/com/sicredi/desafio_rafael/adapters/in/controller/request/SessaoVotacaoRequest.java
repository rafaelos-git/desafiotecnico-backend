package br.com.sicredi.desafio_rafael.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SessaoVotacaoRequest {
    @NotBlank(message = "O ID da pauta e obrigatorio.")
    private String pautaId;
    @Positive(message = "A duracao em minutos deve ser um valor positivo.")
    private Integer duracaoEmMinutos;
}
