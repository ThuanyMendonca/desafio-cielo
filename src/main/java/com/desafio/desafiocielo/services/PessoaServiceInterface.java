package com.desafio.desafiocielo.services;

import com.desafio.desafiocielo.dtos.PessoaFisicaDto;
import com.desafio.desafiocielo.dtos.PessoaFisicaResponseDto;
import com.desafio.desafiocielo.models.PessoaFisica;

import java.util.List;

public interface PessoaServiceInterface {
    String cadastrarPessoaFisica(PessoaFisicaDto pessoaFisica) throws Exception;
    boolean pessoaFisicaExiste(PessoaFisicaDto pessoaFisicaDto);
    Object getByCpf(String cpf);
    Object getByName(String nome);

    List<PessoaFisica> getAllByStatus();
    List<String> getPending() throws Exception;
}
