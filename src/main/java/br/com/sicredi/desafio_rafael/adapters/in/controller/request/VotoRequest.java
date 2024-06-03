package br.com.sicredi.desafio_rafael.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VotoRequest {
    @NotBlank(message = "O CPF do associado e obrigatorio.")
    String cpfAssociado;
    @NotBlank(message = "O voto e obrigatorio.")
    String voto;
}
