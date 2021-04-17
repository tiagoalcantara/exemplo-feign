package br.com.tiago.feigndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cep")
public class DemoController {

    @Autowired
    private ViacepClient viacepClient;

    @GetMapping("/{cep}")
    public ResponseEntity<ViacepConsultarResponse> consultar(
            @PathVariable String cep
    ) {
        return viacepClient.consultar(cep);
    }

    @PostMapping("/validar")
    public ResponseEntity<String> validar(@RequestBody @Valid TesteRequest request) {
        return ResponseEntity.ok("Deu bom!");
    }
}
