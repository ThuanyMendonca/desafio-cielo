package com.desafio.desafiocielo.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TipoDePessoaInvalida extends RuntimeException{
    public TipoDePessoaInvalida(String tipo) {
        super("tipo de pessoa inválida: " + tipo);
    }
}
