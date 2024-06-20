package com.agiotagem_bank.repository;

import com.agiotagem_bank.model.Emprestimo.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
