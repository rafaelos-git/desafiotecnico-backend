package br.com.sicredi.desafio_rafael.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VotoRequest {
    @NotBlank
    String cpfAssociado;
    @NotBlank
    String voto;
}
