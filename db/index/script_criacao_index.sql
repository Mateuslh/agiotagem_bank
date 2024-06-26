--3 agências que mais tiveram transações
CREATE INDEX idx_depositos_data_agencia
    ON depositos (data_deposito);

--Contas do tipo "corrente" com usuários
CREATE INDEX idx_usuarios_data_nascimento
    ON usuarios (data_nascimento);
CREATE INDEX idx_contas_tipo_usuario
    ON contas (tipo_conta, usuario_id);

--cartão de crédito e limite específico
CREATE INDEX idx_cartoes_tipo_limite
    ON cartoes (tipo_cartao, limite);

--Usuários com saldo maior que
CREATE INDEX idx_usuarios_data_nascimento_saldo
    ON usuarios (data_nascimento);
CREATE INDEX idx_contas_saldo_usuario
    ON contas (saldo, usuario_id);
CREATE INDEX idx_agencias_nome
    ON agencias (nome_agencia);

--tabela historico_saldos
CREATE INDEX idx_historico_saldos_data
    ON historico_saldos (data_alteracao);
