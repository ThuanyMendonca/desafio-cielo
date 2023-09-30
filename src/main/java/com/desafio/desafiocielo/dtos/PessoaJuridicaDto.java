package com.desafio.desafiocielo.dtos;

import com.desafio.desafiocielo.models.Pessoa;

public class PessoaJuridicaDto extends PessoaDto{
    private String cnpj;
    private String razaoSocial;

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public PessoaJuridicaDto(Pessoa pessoa, String cnpj, String razaoSocial) {
        super(pessoa);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }
}
