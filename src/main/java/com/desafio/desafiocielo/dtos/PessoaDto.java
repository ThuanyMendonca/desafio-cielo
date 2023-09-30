package com.desafio.desafiocielo.dtos;

import com.desafio.desafiocielo.models.Pessoa;
import com.desafio.desafiocielo.models.enums.PessoaType;

import java.util.UUID;

public class PessoaDto {
    private UUID idPessoa;
    private String name;
    private String cpf;
    private int mcc;
    private String email;

    private String pessoaTipo;
    private String pessoaStatus;

    public PessoaDto(Pessoa pessoa) {
        this.name = pessoa.getName();
        this.cpf = pessoa.getCpf();
        this.pessoaStatus = pessoa.getPessoaStatus().toString();
        this.pessoaTipo = pessoa.getTipo();

    }

    public UUID getIdPessoa() {
        return idPessoa;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public int getMcc() {
        return mcc;
    }

    public String getEmail() {
        return email;
    }

    public String getPessoaTipo() {
        return pessoaTipo;
    }

    public String getPessoaStatus() {
        return pessoaStatus;
    }
}
