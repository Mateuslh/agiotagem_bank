package com.agiotagem_bank.service;

import com.agiotagem_bank.model.deposito.Deposito;
import com.agiotagem_bank.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositoService extends AbstractCadastralService<Deposito, DepositoRepository> {

    @Autowired
    protected DepositoRepository depositoRepository;
}
