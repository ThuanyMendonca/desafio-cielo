package com.desafio.desafiocielo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class PessoaFisica extends Pessoa implements Serializable {
}
