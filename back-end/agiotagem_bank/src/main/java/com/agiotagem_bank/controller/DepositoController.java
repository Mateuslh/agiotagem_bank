package com.agiotagem_bank.controller;

import com.agiotagem_bank.model.deposito.Deposito;
import com.agiotagem_bank.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deposito")
public class DepositoController extends AbstractCadastralController<Deposito, DepositoService> {

    @Autowired
    public DepositoController(DepositoService service) {
        super(service, Deposito.class);
    }

}
