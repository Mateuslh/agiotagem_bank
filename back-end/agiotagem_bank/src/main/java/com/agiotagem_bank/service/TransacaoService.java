package com.agiotagem_bank.service;

import com.agiotagem_bank.model.Transacao.Transacao;
import com.agiotagem_bank.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService extends AbstractCadastralService<Transacao, TransacaoRepository> {

    @Autowired
    protected TransacaoRepository transacaoRepository;
}
