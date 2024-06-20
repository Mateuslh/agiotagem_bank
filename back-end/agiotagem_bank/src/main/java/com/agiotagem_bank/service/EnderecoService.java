package com.agiotagem_bank.service;

import com.agiotagem_bank.model.endereco.Endereco.Endereco;
import com.agiotagem_bank.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends AbstractCadastralService<Endereco, EnderecoRepository> {

    @Autowired
    protected EnderecoRepository enderecoRepository;
}
