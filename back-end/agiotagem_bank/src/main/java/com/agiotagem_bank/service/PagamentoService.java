package com.agiotagem_bank.service;

import com.agiotagem_bank.model.pagamento.Pagamento;
import com.agiotagem_bank.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService extends AbstractCadastralService<Pagamento, PagamentoRepository> {

    @Autowired
    protected PagamentoRepository pagamentoRepository;
}
