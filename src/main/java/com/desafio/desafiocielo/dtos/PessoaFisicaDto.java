package com.desafio.desafiocielo.dtos;

import com.desafio.desafiocielo.models.Pessoa;
import com.desafio.desafiocielo.models.PessoaFisica;
import com.desafio.desafiocielo.models.enums.PessoaStatus;
import com.desafio.desafiocielo.models.enums.PessoaType;
import jakarta.validation.constraints.Email;

public class PessoaFisicaDto {
    private String cpf;
    private String name;
    @Email(message = "Email inválido")
    private String email;
    private int mcc;
    private String tipo;

    public PessoaFisicaDto(String cpf, String name, String email, int mcc, String tipo) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.mcc = mcc;
        this.tipo = tipo;
    }

    public PessoaFisicaDto(PessoaFisica pessoaFisica) {
        this.cpf = pessoaFisica.getCpf();
        this.name = pessoaFisica.getName();
        this.mcc = pessoaFisica.getMcc();
        this.tipo = pessoaFisica.getTipo();
        this.email = pessoaFisica.getEmail();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
