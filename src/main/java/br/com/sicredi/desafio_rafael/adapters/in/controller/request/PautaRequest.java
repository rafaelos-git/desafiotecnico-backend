package br.com.sicredi.desafio_rafael.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PautaRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
}
