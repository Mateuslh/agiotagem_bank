package com.agiotagem_bank.repository;

import com.agiotagem_bank.model.Transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
