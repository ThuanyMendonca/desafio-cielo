package com.desafio.desafiocielo.dtos;

import com.desafio.desafiocielo.models.PessoaFisica;

public class PessoaFisicaResponseDto {
    private String id;
    private String cpf;
    private String name;
    private int mcc;
    private String email;
    private String status;
    private String tipo;

    public PessoaFisicaResponseDto(PessoaFisica pessoaFisica) {
        this.cpf = pessoaFisica.getCpf();
        this.name = pessoaFisica.getName();
        this.mcc = pessoaFisica.getMcc();
        this.email = pessoaFisica.getEmail();
        this.status = pessoaFisica.getPessoaStatus();
        this.tipo = pessoaFisica.getTipo();
    }
}
