package com.desafio.desafiocielo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Size(max = 4)
    @NotNull
    private int mcc;

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    @NotBlank
    private String email;

}
