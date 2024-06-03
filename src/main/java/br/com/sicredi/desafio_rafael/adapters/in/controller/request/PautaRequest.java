package br.com.sicredi.desafio_rafael.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PautaRequest {
    @NotBlank(message = "A pauta deve ter um nome.")
    private String nome;
    @NotBlank(message = "A pauta deve ter uma descricao.")
    private String descricao;
}
