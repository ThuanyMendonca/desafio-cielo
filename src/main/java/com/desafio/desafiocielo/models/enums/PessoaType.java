package com.desafio.desafiocielo.models.enums;

public enum PessoaType {
    PESSOA_FISICA("pessoa_fisica"),
    PESSOA_JURIDICA("Pessoa_juridica");

    public final String label;
    private PessoaType(String label) {
        this.label = label;
    }
}
