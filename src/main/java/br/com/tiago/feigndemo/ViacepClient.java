package br.com.tiago.feigndemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br")
public interface ViacepClient {

    @GetMapping("/ws/{cep}/json/")
    ResponseEntity<ViacepConsultarResponse> consultar(@PathVariable String cep);
}
