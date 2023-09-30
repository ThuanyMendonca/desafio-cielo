package com.desafio.desafiocielo.controllers;

import com.desafio.desafiocielo.dtos.PessoaFisicaDto;
import com.desafio.desafiocielo.dtos.PessoaFisicaResponseDto;
import com.desafio.desafiocielo.models.PessoaFisica;
import com.desafio.desafiocielo.services.PessoaServiceInterface;
import com.desafio.desafiocielo.services.exceptions.PessoaNotFound;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prospect")
public class PessoaFisicaController {
    @Autowired
    private final PessoaServiceInterface pessoa;

    public PessoaFisicaController(PessoaServiceInterface pessoa) {
        this.pessoa = pessoa;
    }

    @PostMapping
    public ResponseEntity<Object> sendPessoaFisica(@Valid @RequestBody PessoaFisicaDto pessoaFisica){
        if(pessoa.pessoaFisicaExiste(pessoaFisica)) {
            return new ResponseEntity<>("o cpf digitado já existe", HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(pessoa.cadastrarPessoaFisica(pessoaFisica), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Object> getByCpf(@Valid @PathVariable String cpf) {
        Object response = pessoa.getByCpf(cpf);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<Object> getByNome(@Valid @RequestParam("name") String nome) {
        return new ResponseEntity<>(pessoa.getByName(nome), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PessoaFisica>> getAllByStatusTipo() {
        return new ResponseEntity<>(pessoa.getAllByStatus(), HttpStatus.OK);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<String>> getAllPending() {
        try {
            return new ResponseEntity<>(pessoa.getPending(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PutMapping("/confirm")
    public String confirm(){
        // fazer update no banco e deletar da fila
        return "";
    }
}
