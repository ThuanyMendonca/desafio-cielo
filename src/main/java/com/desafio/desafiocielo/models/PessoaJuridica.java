package com.desafio.desafiocielo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class PessoaJuridica extends Pessoa implements Serializable {
    @CNPJ(message = "CNPJ inválido")
    @Size(max = 14)
    @NotBlank
    private String cnpj;
    @Size(max = 50)
    @NotBlank
    private String razaoSocial;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

}
