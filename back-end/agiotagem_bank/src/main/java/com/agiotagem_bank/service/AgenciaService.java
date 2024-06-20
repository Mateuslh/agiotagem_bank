package com.agiotagem_bank.service;

import com.agiotagem_bank.model.agencia.Agencia;
import com.agiotagem_bank.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService extends AbstractCadastralService<Agencia, AgenciaRepository> {

    @Autowired
    protected AgenciaRepository agenciaRepository;
}
