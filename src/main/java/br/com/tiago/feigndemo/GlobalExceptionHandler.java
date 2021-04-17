package br.com.tiago.feigndemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroDeValidacaoResponse>> handle(MethodArgumentNotValidException e) {

        List<ErroDeValidacaoResponse> listaDeErros = new ArrayList<>();

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            ErroDeValidacaoResponse erro = new ErroDeValidacaoResponse(fieldError.getDefaultMessage(), fieldError.getField());
            listaDeErros.add(erro);
        });

        return ResponseEntity.badRequest().body(listaDeErros);
    }
}
