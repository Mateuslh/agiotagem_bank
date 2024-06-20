package com.agiotagem_bank.controller;

import com.agiotagem_bank.model.agencia.Agencia;
import com.agiotagem_bank.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agencia")
public class AgenciaController extends AbstractCadastralController<Agencia, AgenciaService> {

    @Autowired
    public AgenciaController(AgenciaService service) {
        super(service, Agencia.class);
    }

}
