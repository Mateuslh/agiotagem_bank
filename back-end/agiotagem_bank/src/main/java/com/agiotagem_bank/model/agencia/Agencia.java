package com.agiotagem_bank.model.agencia;

import com.agiotagem_bank.model.EntityId;
import com.agiotagem_bank.model.endereco.Endereco.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "agencias")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agencia extends EntityId {

    @ManyToOne
    @JoinColumn
    private Endereco endereco;

    private String nomeAgencia;
    private String telefone;

}
