package com.desafio.desafiocielo.services;

import com.amazonaws.services.sqs.model.Message;
import com.desafio.desafiocielo.config.AwsSNSConfig;
import com.desafio.desafiocielo.config.AwsSQSConfig;
import com.desafio.desafiocielo.dtos.*;
import com.desafio.desafiocielo.models.PessoaFisica;
import com.desafio.desafiocielo.models.enums.PessoaType;
import com.desafio.desafiocielo.repositories.PessoaFisicaRepository;
import com.desafio.desafiocielo.repositories.PessoaJuridicaRepository;
import com.desafio.desafiocielo.repositories.PessoaRepository;
import com.desafio.desafiocielo.services.exceptions.PessoaNotFound;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements PessoaServiceInterface{
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private AwsSNSConfig awsSNSConfig;

    @Autowired
    private AwsSQSConfig awsSQSConfig;

    public String cadastrarPessoaFisica(PessoaFisicaDto pessoaFisica) throws Exception {
        if(!pessoaFisica.getTipo().equals(PessoaType.PESSOA_FISICA.label)) {
            return "tipo inválido";
        }

        criaPessoaFisicaDb(pessoaFisica);
        PessoaSNS pessoaSNS = new PessoaSNS();
        pessoaSNS.setName(pessoaFisica.getName());
        pessoaSNS.setCpf(pessoaFisica.getCpf());
        pessoaSNS.setEmail(pessoaFisica.getEmail());
        pessoaSNS.setStatus("RECEBIDO");
        pessoaSNS.setTipo(pessoaFisica.getTipo());
        pessoaSNS.setMessage(toJson(pessoaSNS));

        awsSNSConfig.publishSNS(pessoaSNS);
        return "cadastrado com sucesso";
    }

    public PessoaFisicaResponseDto criaPessoaFisicaDb(PessoaFisicaDto pessoaFisicaDto) {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.save(new PessoaFisica(pessoaFisicaDto.getName(), pessoaFisicaDto.getCpf(), pessoaFisicaDto.getMcc(), pessoaFisicaDto.getEmail(), pessoaFisicaDto.getTipo(), "RECEBIDO"));
        PessoaFisicaResponseDto pessoa = new PessoaFisicaResponseDto(pessoaFisica);
        return pessoa;
    }

    public boolean pessoaFisicaExiste(PessoaFisicaDto pessoaFisicaDto) {
        boolean exist = pessoaFisicaRepository.existsPessoaFisicaByCpf(pessoaFisicaDto.getCpf());
        if(!exist) {
            return false;
        }
        return true;
    }

    public Object getByCpf(String cpf) {
        Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaRepository.getByCpf(cpf);

        if(pessoaFisicaOptional.isPresent()) {
            return pessoaFisicaOptional.get();
        }
        throw new PessoaNotFound("pessoa não encontrada");
    }

    public PessoaFisica getByName(String nome) {
        PessoaFisica pessoaFisicaOptional = pessoaFisicaRepository.getPessoaFisicaByNameContaining(nome);

        if(pessoaFisicaOptional != null) {
            return pessoaFisicaOptional;
        }
        throw new PessoaNotFound("pessoa não encontrada");
    }

    public List<PessoaFisica> getAllByStatus() {
        List<PessoaFisica> lista = pessoaFisicaRepository.findAllByPessoaStatusAndTipo("CADASTRADO", "pessoa_fisica");

        if(lista.isEmpty()) {
            throw new PessoaNotFound("não existe nenhum cliente");
        }

        return lista;
    }

    public List<String> getPending() throws Exception{
        List<String> messagesList = awsSQSConfig.getMessages();
        PessoaSNS pessoaSNS = new PessoaSNS();
        System.out.println(messagesList.get(0));
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            PessoaSQS pessoaSNS1 = objectMapper.readValue(messagesList.get(0), PessoaSQS.class);
            System.out.println(pessoaSNS1);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return messagesList;
    }

    public Object toJson(Object value) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(value);

        return json;
    }
}
