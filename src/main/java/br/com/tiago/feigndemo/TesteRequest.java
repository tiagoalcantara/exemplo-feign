package br.com.tiago.feigndemo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class TesteRequest {
    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;

    public TesteRequest(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
