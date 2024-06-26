--Trigger que adciona uma nova linha na tabela "historico_saldos" quando a coluna saldos for alterada.
CREATE TRIGGER trigger_registro_historico_saldos
AFTER UPDATE OF saldo ON contas
FOR EACH ROW
EXECUTE FUNCTION registrar_historico_saldos_trigger();