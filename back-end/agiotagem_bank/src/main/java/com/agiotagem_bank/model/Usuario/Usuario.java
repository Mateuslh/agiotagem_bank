package com.agiotagem_bank.model.Usuario;

import com.agiotagem_bank.model.EntityId;
import com.agiotagem_bank.model.endereco.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends EntityId {

    private String nome;
    private String email;
    private String senha;
    private String telefone;

    @ManyToOne
    @JoinColumn
    private Endereco endereco;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
}
