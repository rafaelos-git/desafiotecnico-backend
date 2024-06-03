package br.com.sicredi.desafio_rafael.adapters.out;

import br.com.sicredi.desafio_rafael.adapters.out.client.CpfValidationClient;
import br.com.sicredi.desafio_rafael.application.ports.out.SendCpfForValidationOutputPort;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class SendCpfForValidationAdapter implements SendCpfForValidationOutputPort {
    @Autowired
    private CpfValidationClient cpfValidationClient;

    @Override
    public String send(String cpf) {
        try {
            var response = cpfValidationClient.validateCpf(cpf);
            if (response.getStatusCode() == HttpStatus.OK) {
                var cpfValidationResponse = response.getBody();
                return cpfValidationResponse != null ? cpfValidationResponse.getStatus() : "UNABLE_TO_VOTE";
            } else {
                return "UNABLE_TO_VOTE";
            }
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF invalido");
        }
    }
}
