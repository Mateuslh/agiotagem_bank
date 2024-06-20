package com.agiotagem_bank.service;

import com.agiotagem_bank.model.cartao.Cartao;
import com.agiotagem_bank.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService extends AbstractCadastralService<Cartao, CartaoRepository> {

    @Autowired
    protected CartaoRepository cartaoRepository;
}
