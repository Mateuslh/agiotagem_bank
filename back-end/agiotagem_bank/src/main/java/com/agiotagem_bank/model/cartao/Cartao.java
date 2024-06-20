package com.agiotagem_bank.model.cartao;

import com.agiotagem_bank.model.EntityId;
import com.agiotagem_bank.model.conta.Conta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "cartoes")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cartao extends EntityId {

    @JoinColumn
    @ManyToOne
    private Conta conta;

    private String numeroCartao;
    private Date validade;
    private String codigoSeguranca;

    @Column(precision = 15, scale = 2)
    private BigDecimal limite;
    @Enumerated(EnumType.STRING)
    private TipoCartao tipoCartao;

}
