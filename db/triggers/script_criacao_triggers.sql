--Trigger que adciona uma nova linha na tabela "historico_saldos" quando a coluna saldos for alterada.
CREATE OR REPLACE FUNCTION registrar_historico_saldos_trigger()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO historico_saldos (id, conta_id, saldo_anterior, saldo_atual, data_alteracao)
    VALUES (OLD.id, OLD.saldo, NEW.saldo, NOW());

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;