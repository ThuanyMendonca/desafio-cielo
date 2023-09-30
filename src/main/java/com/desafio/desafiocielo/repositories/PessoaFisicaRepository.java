package com.desafio.desafiocielo.repositories;
import com.desafio.desafiocielo.dtos.PessoaFisicaDto;
import com.desafio.desafiocielo.dtos.PessoaFisicaResponseDto;
import com.desafio.desafiocielo.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafiocielo.models.PessoaFisica;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, UUID> {
    boolean existsPessoaFisicaByCpf(String cpf);
    Optional<PessoaFisica> getByCpf(String cpf);
    PessoaFisica getPessoaFisicaByNameContaining(String nome);

    List<PessoaFisica> findAllByPessoaStatusAndTipo(String status, String tipo);
}
