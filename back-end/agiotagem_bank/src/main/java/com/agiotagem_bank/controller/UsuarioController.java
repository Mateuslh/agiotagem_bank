package com.agiotagem_bank.controller;

import com.agiotagem_bank.model.Usuario.Usuario;
import com.agiotagem_bank.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends AbstractCadastralController<Usuario, UsuarioService> {

    @Autowired
    public UsuarioController(UsuarioService service) {
        super(service, Usuario.class);
    }

}
