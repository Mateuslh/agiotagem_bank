package com.agiotagem_bank.controller;

import com.agiotagem_bank.model.cartao.Cartao;
import com.agiotagem_bank.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartao")
public class CartaoController extends AbstractCadastralController<Cartao, CartaoService> {

    @Autowired
    public CartaoController(CartaoService service) {
        super(service, Cartao.class);
    }

}
