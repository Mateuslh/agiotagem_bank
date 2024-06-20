package com.agiotagem_bank.model.endereco.Endereco;

import com.agiotagem_bank.model.EntityId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "enderecos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco extends EntityId {
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
}
