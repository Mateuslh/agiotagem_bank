package com.agiotagem_bank.model.Transacao;

import com.agiotagem_bank.model.EntityId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos_transacoes")
public class TipoTransacao extends EntityId {
    private String descricao;
}
