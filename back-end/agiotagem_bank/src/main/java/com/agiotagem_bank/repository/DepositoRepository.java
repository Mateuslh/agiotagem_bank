package com.agiotagem_bank.repository;

import com.agiotagem_bank.model.deposito.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoRepository extends JpaRepository<Deposito, Long> {
}
