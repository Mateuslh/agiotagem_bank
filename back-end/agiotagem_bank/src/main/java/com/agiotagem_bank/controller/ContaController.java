package com.agiotagem_bank.controller;

import com.agiotagem_bank.model.conta.Conta;
import com.agiotagem_bank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conta")
public class ContaController extends AbstractCadastralController<Conta, ContaService> {

    @Autowired
    public ContaController(ContaService service) {
        super(service, Conta.class);
    }

}
