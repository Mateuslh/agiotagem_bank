package com.agiotagem_bank.repository;

import com.agiotagem_bank.model.Transacao.TipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoTransacaoRepository extends JpaRepository<TipoTransacao, Long> {
}
