--Procedure para transferir saldo de uma conta para outra e adicionar historico na tabela "tranferencia".
CREATE OR REPLACE PROCEDURE public.transferir_dinheiro(conta_origem_id BIGINT, conta_destino_id BIGINT, valor_transferencia NUMERIC, tipo_transacao_id BIGINT, descricao TEXT)
LANGUAGE plpgsql
AS $$
DECLARE
    saldo_origem NUMERIC;
BEGIN
    SELECT saldo INTO saldo_origem
    FROM contas
    WHERE id = conta_origem_id;

    IF saldo_origem < valor_transferencia THEN RAISE EXCEPTION 'Saldo insuficiente na conta de origem.';
    END IF;

    UPDATE contas
    SET saldo = saldo - valor_transferencia
    WHERE id = conta_origem_id;

    UPDATE contas
    SET saldo = saldo + valor_transferencia
    WHERE id = conta_destino_id;

    INSERT INTO transacoes (conta_origem_id, conta_destino_id, tipo_transacao_id, valor, descricao)
    VALUES (conta_origem_id, conta_destino_id, tipo_transacao_id, valor_transferencia, descricao);
END;
$$;

CALL transferir_dinheiro(2, 1, 500.00, 2, 'teste 1');