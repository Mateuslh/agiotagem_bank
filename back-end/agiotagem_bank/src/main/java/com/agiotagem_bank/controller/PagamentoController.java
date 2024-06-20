package com.agiotagem_bank.controller;

import com.agiotagem_bank.model.pagamento.Pagamento;
import com.agiotagem_bank.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController extends AbstractCadastralController<Pagamento, PagamentoService> {

    @Autowired
    public PagamentoController(PagamentoService service) {
        super(service, Pagamento.class);
    }

}
