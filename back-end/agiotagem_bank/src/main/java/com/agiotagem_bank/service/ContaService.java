package com.agiotagem_bank.service;

import com.agiotagem_bank.model.conta.Conta;
import com.agiotagem_bank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService extends AbstractCadastralService<Conta, ContaRepository> {

    @Autowired
    protected ContaRepository contaRepository;
}
