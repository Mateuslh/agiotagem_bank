package com.agiotagem_bank.model.deposito;

import com.agiotagem_bank.model.EntityId;
import com.agiotagem_bank.model.conta.Conta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "depositos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deposito extends EntityId {

    @ManyToOne
    @JoinColumn
    private Conta conta;

    @Column(precision = 15, scale = 2)
    private BigDecimal valor;

    private LocalDateTime dataDeposito;

    private String descricao;
}
