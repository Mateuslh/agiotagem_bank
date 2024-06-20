package com.agiotagem_bank.controller;

import com.agiotagem_bank.model.Transacao.Transacao;
import com.agiotagem_bank.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController extends AbstractCadastralController<Transacao, TransacaoService> {

    @Autowired
    public TransacaoController(TransacaoService service) {
        super(service, Transacao.class);
    }

}
