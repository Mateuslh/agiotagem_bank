package com.agiotagem_bank.service;

import com.agiotagem_bank.model.Transacao.TipoTransacao;
import com.agiotagem_bank.repository.TipoTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoTransacaoService extends AbstractCadastralService<TipoTransacao, TipoTransacaoRepository> {

    @Autowired
    protected TipoTransacaoRepository tipoTransacaoRepository;
}
