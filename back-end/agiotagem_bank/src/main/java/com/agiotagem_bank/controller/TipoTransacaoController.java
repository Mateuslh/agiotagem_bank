package com.agiotagem_bank.controller;

import com.agiotagem_bank.model.Transacao.TipoTransacao;
import com.agiotagem_bank.service.TipoTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipoTransacao")
public class TipoTransacaoController extends AbstractCadastralController<TipoTransacao, TipoTransacaoService> {

    @Autowired
    public TipoTransacaoController(TipoTransacaoService service) {
        super(service, TipoTransacao.class);
    }

}
