package com.agiotagem_bank.model.Emprestimo;

import com.agiotagem_bank.model.EntityId;
import com.agiotagem_bank.model.Usuario.Usuario;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emprestimos")
public class Emprestimo extends EntityId {
    @ManyToOne
    @JoinColumn
    private Usuario usuario;

    @ManyToOne
    @JoinColumn
    private Conta contaDestino;

    @Column(precision = 15, scale = 2)
    private BigDecimal valorEmprestimo;

    @Column(precision = 3, scale = 6)
    private BigDecimal taxaJuros;

    private LocalDateTime dataContratacao;
    private LocalDateTime dataVencimento;
}
