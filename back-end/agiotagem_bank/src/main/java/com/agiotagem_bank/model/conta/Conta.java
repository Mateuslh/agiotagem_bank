package com.agiotagem_bank.model.conta;

import com.agiotagem_bank.model.EntityId;
import com.agiotagem_bank.model.Usuario.Usuario;
import com.agiotagem_bank.model.agencia.Agencia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "contas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conta extends EntityId {

    @JoinColumn
    @ManyToOne
    private Usuario usuario;

    @JoinColumn
    @ManyToOne
    private Agencia agencia;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(precision = 15, scale = 2)
    private BigDecimal saldo;

    @Temporal(TemporalType.DATE)
    private Date dataAbertura;

}
