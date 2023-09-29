package com.desafio.desafiocielo.repositories;
import com.desafio.desafiocielo.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafiocielo.models.PessoaFisica;

import java.util.UUID;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, UUID> {
}
