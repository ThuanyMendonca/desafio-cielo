package com.desafio.desafiocielo.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFound extends RuntimeException{
    public PessoaNotFound(String messagem) {
        super(messagem);
    }
}
