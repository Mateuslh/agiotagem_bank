package com.agiotagem_bank.repository;

import com.agiotagem_bank.model.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
