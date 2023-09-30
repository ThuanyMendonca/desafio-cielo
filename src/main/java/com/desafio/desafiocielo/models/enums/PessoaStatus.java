package com.desafio.desafiocielo.models.enums;

public enum PessoaStatus {
    RECEBIDO("RECEBIDO"),
    CADASTRADO("CADASTRADO");

    public final String label;

    private PessoaStatus(String label) {
        this.label = label;
    }
}
