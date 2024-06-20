package com.agiotagem_bank.repository;

import com.agiotagem_bank.model.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
