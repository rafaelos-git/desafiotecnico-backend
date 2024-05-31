package br.com.sicredi.desafio_rafael.adapters.out.client;

import br.com.sicredi.desafio_rafael.adapters.out.client.response.CpfValidationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "validaCliente", url = "https://run.mocky.io/v3")
public interface CpfValidationClient {
    @GetMapping("/57f23672-c15f-48f8-90d3-d84ce00250b8/users/{cpf}")
    ResponseEntity<CpfValidationResponse> validateCpf(@PathVariable("cpf") String cpf);
}
