package com.agiotagem_bank.repository;

import com.agiotagem_bank.model.agencia.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}
