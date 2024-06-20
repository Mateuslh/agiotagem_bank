package com.agiotagem_bank.repository;

import com.agiotagem_bank.model.endereco.Endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
