package com.agiotagem_bank.model.Transacao;

import com.agiotagem_bank.model.EntityId;
import com.agiotagem_bank.model.conta.Conta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transacoes")
public class Transacao extends EntityId {

    @JoinColumn
    @ManyToOne
    private Conta contaOrigem;

    @JoinColumn
    @ManyToOne
    private Conta contaDestino;

    @JoinColumn
    @ManyToOne
    private TipoTransacao tipoTransacao;

    @Column(precision = 15, scale = 2)
    private BigDecimal valor;

    private LocalDateTime dataTransacao = LocalDateTime.now();
    private String descricao;
}
