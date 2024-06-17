package com.agiotagem_bank.model.agencia;

import com.agiotagem_bank.model.EntityId;
import com.agiotagem_bank.model.endereco.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;


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
