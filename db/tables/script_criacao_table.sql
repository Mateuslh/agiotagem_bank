CREATE TABLE enderecos (
    endereco_id SERIAL PRIMARY KEY,
    rua VARCHAR(100),
    numero VARCHAR(10),
    cidade VARCHAR(50),
    estado VARCHAR(50),
    cep VARCHAR(15)
);

CREATE TABLE usuarios (
    usuario_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    data_nascimento DATE,
    telefone VARCHAR(15),
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES enderecos(endereco_id)
);

CREATE TABLE agencias (
    agencia_id SERIAL PRIMARY KEY,
    nome_agencia VARCHAR(100) NOT NULL,
    endereco_id INT,
    telefone VARCHAR(15),
    FOREIGN KEY (endereco_id) REFERENCES enderecos(endereco_id)
);

CREATE TABLE contas (
    conta_id SERIAL PRIMARY KEY,
    usuario_id INT NOT NULL,
    agencia_id INT NOT NULL,
    tipo_conta VARCHAR(50),
    saldo NUMERIC(15, 2) DEFAULT 0.00,
    data_abertura DATE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (agencia_id) REFERENCES agencias(agencia_id)
);

CREATE TABLE tipos_transacoes (
    tipo_transacao_id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);

CREATE TABLE transacoes (
    transacao_id SERIAL PRIMARY KEY,
    conta_origem_id INT NOT NULL,
    conta_destino_id INT NOT NULL,
    tipo_transacao_id INT NOT NULL,
    valor NUMERIC(15, 2),
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descricao TEXT,
    FOREIGN KEY (conta_origem_id) REFERENCES contas(conta_id),
    FOREIGN KEY (conta_destino_id) REFERENCES contas(conta_id),
    FOREIGN KEY (tipo_transacao_id) REFERENCES tipos_transacoes(tipo_transacao_id)
);

CREATE TABLE cartoes (
    cartao_id SERIAL PRIMARY KEY,
    conta_id INT NOT NULL,
    numero_cartao VARCHAR(16) UNIQUE NOT NULL,
    validade DATE,
    codigo_seguranca VARCHAR(4),
    limite NUMERIC(15, 2),
    tipo_cartao VARCHAR(50),
    FOREIGN KEY (conta_id) REFERENCES contas(conta_id)
);

CREATE TABLE emprestimos (
    emprestimo_id SERIAL PRIMARY KEY,
    usuario_id INT NOT NULL,
    valor_emprestimo NUMERIC(15, 2),
    taxa_juros NUMERIC(5, 2),
    data_contratacao DATE,
    data_vencimento DATE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

CREATE TABLE pagamentos (
    pagamento_id SERIAL PRIMARY KEY,
    conta_id INT NOT NULL,
    cartao_id INT,
    valor NUMERIC(15, 2),
    data_pagamento DATE,
    descricao TEXT,
    FOREIGN KEY (conta_id) REFERENCES contas(conta_id),
    FOREIGN KEY (cartao_id) REFERENCES cartoes(cartao_id)
);

CREATE TABLE depositos (
    deposito_id SERIAL PRIMARY KEY,
    conta_id INT NOT NULL,
    valor NUMERIC(15, 2),
    data_deposito DATE,
    descricao TEXT,
    FOREIGN KEY (conta_id) REFERENCES contas(conta_id)
);

CREATE TABLE historico_saldos (
    historico_saldo_id SERIAL PRIMARY KEY,
    conta_id INT NOT NULL,
    saldo_anterior NUMERIC(15, 2),
    saldo_atual NUMERIC(15, 2),
    data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (conta_id) REFERENCES contas(conta_id)
);