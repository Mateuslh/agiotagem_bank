package com.agiotagem_bank.model.pagamento;

import com.agiotagem_bank.model.EntityId;
import com.agiotagem_bank.model.cartao.Cartao;
import com.agiotagem_bank.model.conta.Conta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "pagamentos")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento extends EntityId {

    @JoinColumn
    @ManyToOne
    private Conta conta;

    @JoinColumn
    @ManyToOne
    private Cartao cartao;

    @Column(precision = 15, scale = 2)
    private BigDecimal valor;

    private LocalDateTime dataPagamento;
    private String descricao;
}
