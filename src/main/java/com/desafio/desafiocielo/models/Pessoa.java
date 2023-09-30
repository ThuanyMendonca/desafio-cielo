package com.desafio.desafiocielo.models;

import com.desafio.desafiocielo.models.enums.PessoaStatus;
import com.desafio.desafiocielo.models.enums.PessoaType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPessoa;

    @Size(max = 50)
    @NotBlank
    private String name;

    @CPF(message = "CPF inválido")
    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotNull
    private int mcc;

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    @NotBlank
    private String email;

    @NotBlank
    private String tipo;

    @NotBlank
    private String pessoaStatus;
    public Pessoa(String name, String cpf, int mcc, String email, String tipo, String pessoaStatus) {
        this.name = name;
        this.cpf = cpf;
        this.mcc = mcc;
        this.email = email;
        this.tipo = tipo;
        this.pessoaStatus = pessoaStatus;
    }

    public Pessoa() {

    }

    public UUID getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(UUID idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPessoaStatus() {
        return pessoaStatus;
    }

    public void setPessoaStatus(String pessoaStatus) {
        this.pessoaStatus = pessoaStatus;
    }
}
