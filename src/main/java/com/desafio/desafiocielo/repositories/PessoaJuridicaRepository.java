package com.desafio.desafiocielo.repositories;

import com.desafio.desafiocielo.models.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, UUID> {
}
