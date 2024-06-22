CREATE TABLE enderecos (
    id BIGSERIAL PRIMARY KEY,
    logradouro VARCHAR(100),
    numero VARCHAR(10),
    cidade VARCHAR(50),
    estado VARCHAR(50),
    cep VARCHAR(15)
);

CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    data_nascimento DATE,
    telefone VARCHAR(15),
    endereco_id BIGSERIAL,
    FOREIGN KEY (endereco_id) REFERENCES enderecos(id)
);

CREATE TABLE agencias (
    id BIGSERIAL PRIMARY KEY,
    nome_agencia VARCHAR(100) NOT NULL,
    endereco_id BIGSERIAL,
    telefone VARCHAR(15),
    FOREIGN KEY (endereco_id) REFERENCES enderecos(id)
);

CREATE TABLE contas (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGSERIAL NOT NULL,
    agencia_id BIGSERIAL NOT NULL,
    tipo_conta VARCHAR(50),
    saldo NUMERIC(15, 2) DEFAULT 0.00,
    data_abertura DATE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (agencia_id) REFERENCES agencias(id)
);

CREATE TABLE tipos_transacoes (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);

CREATE TABLE transacoes (
    id BIGSERIAL PRIMARY KEY,
    conta_origem_id BIGSERIAL NOT NULL,
    conta_destino_id BIGSERIAL NOT NULL,
    tipo_transacao_id BIGSERIAL NOT NULL,
    valor NUMERIC(15, 2),
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descricao TEXT,
    FOREIGN KEY (conta_origem_id) REFERENCES contas(id),
    FOREIGN KEY (conta_destino_id) REFERENCES contas(id),
    FOREIGN KEY (tipo_transacao_id) REFERENCES tipos_transacoes(id)
);

CREATE TABLE cartoes (
    id BIGSERIAL PRIMARY KEY,
    conta_id BIGSERIAL NOT NULL,
    numero_cartao VARCHAR(16) UNIQUE NOT NULL,
    validade TIMESTAMP(6),
    codigo_seguranca VARCHAR(4),
    limite NUMERIC(15, 2),
    tipo_cartao VARCHAR(50),
    FOREIGN KEY (conta_id) REFERENCES contas(id)
);

CREATE TABLE emprestimos (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGSERIAL NOT NULL,
    conta_destino_id BIGSERIAL NOT NULL,
    valor_emprestimo NUMERIC(15, 2),
    taxa_juros NUMERIC(5, 2),
    data_contratacao DATE,
    data_vencimento DATE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (conta_destino_id) REFERENCES contas(id)
);

CREATE TABLE pagamentos (
    id BIGSERIAL PRIMARY KEY,
    conta_id BIGSERIAL NOT NULL,
    cartao_id BIGSERIAL,
    valor NUMERIC(15, 2),
    data_pagamento TIMESTAMP(6),
    descricao TEXT,
    FOREIGN KEY (conta_id) REFERENCES contas(id),
    FOREIGN KEY (cartao_id) REFERENCES cartoes(id)
);

CREATE TABLE depositos (
    id BIGSERIAL PRIMARY KEY,
    conta_id BIGSERIAL NOT NULL,
    valor NUMERIC(15, 2),
    data_deposito DATE,
    descricao TEXT,
    FOREIGN KEY (conta_id) REFERENCES contas(id)
);

CREATE TABLE historico_saldos (
    id BIGSERIAL PRIMARY KEY,
    conta_id BIGSERIAL NOT NULL,
    saldo_anterior NUMERIC(15, 2),
    saldo_atual NUMERIC(15, 2),
    data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (conta_id) REFERENCES contas(id)
);