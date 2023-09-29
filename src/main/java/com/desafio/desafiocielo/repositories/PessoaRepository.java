package com.desafio.desafiocielo.repositories;

import com.desafio.desafiocielo.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}
