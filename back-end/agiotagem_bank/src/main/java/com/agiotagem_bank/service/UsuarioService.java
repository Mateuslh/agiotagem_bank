package com.agiotagem_bank.service;

import com.agiotagem_bank.model.Usuario.Usuario;
import com.agiotagem_bank.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractCadastralService<Usuario, UsuarioRepository> {

    @Autowired
    protected UsuarioRepository usuarioRepository;
}
