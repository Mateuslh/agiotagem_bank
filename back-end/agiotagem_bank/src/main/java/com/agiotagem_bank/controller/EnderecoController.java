package com.agiotagem_bank.controller;

import com.agiotagem_bank.model.endereco.Endereco.Endereco;
import com.agiotagem_bank.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController extends AbstractCadastralController<Endereco, EnderecoService> {

    @Autowired
    public EnderecoController(EnderecoService service) {
        super(service, Endereco.class);
    }

}
