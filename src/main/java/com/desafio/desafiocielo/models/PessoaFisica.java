package com.desafio.desafiocielo.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class PessoaFisica extends Pessoa implements Serializable {

    public PessoaFisica(String name, String cpf, int mcc, String email, String pessoaTipo, String pessoaStatus) {
        super(name, cpf, mcc, email, pessoaTipo, pessoaStatus);
    }

    public PessoaFisica() {
        super();
    }

}
