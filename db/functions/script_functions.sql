--Qual as 3 agencias que mais tiveram transações do tipo "deposito" no ano de 2024.--
CREATE OR REPLACE FUNCTION public.top_agencias_depositos(ano integer)
    RETURNS TABLE(agencia_id bigint, nome_agencia character varying, total_depositos bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY
    SELECT 
        ag.id AS agencia_id, ag.nome_agencia, COUNT(d.id) AS total_depositos

    FROM agencias ag

    JOIN contas c ON ag.id = c.agencia_id

    JOIN depositos d ON c.id = d.conta_id

    WHERE EXTRACT(YEAR FROM d.data_deposito) = ano

    GROUP BY ag.id, ag.nome_agencia

    ORDER BY total_depositos DESC LIMIT 3;
END;
$BODY$;
--SELECT * FROM top_agencias_depositos(2024)--

--Quais contas do tipo "corrente" possuem seu usuário com data de nascimento maior que "1990".--
CREATE OR REPLACE FUNCTION public.contas_corrente_usuarios_nascimento(ano_nascimento date)

    RETURNS TABLE(conta_id bigint, usuario_id bigint, nome_usuario character varying, data_nascimento date, tipo_conta character varying, saldo numeric) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY
    SELECT c.id AS conta_id, u.id AS usuario_id, u.nome AS nome_usuario, u.data_nascimento, c.tipo_conta, c.saldo

    FROM contas c

    JOIN usuarios u ON c.usuario_id = u.id

    WHERE c.tipo_conta = 'Conta Corrente' AND u.data_nascimento > ano_nascimento;
END;
$BODY$;
--SELECT * FROM public.contas_corrente_usuarios_nascimento('1990-01-01')--


--Quais usuários com cartão de tipo "crédito" possuem limite de R$6.000.--
CREATE OR REPLACE FUNCTION public.usuarios_com_limite_especifico(
	limite_cartao numeric)
    RETURNS TABLE(id bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY
    SELECT u.id
    FROM usuarios u
    JOIN contas c ON u.id = c.usuario_id
    JOIN cartoes ca ON c.id = ca.conta_id
    WHERE ca.tipo_cartao = 'crédito'
        AND ca.limite = limite_cartao;
END;
$BODY$;
--SELECT * FROM public.usuarios_com_limite_especifico(6000.00)--

--Quais usuários com data de nascimento antes do ano "1990" possuem saldo maior que 10000 na agencia "Agência Central".--
CREATE OR REPLACE FUNCTION public.usuarios_saldo_agencia(ano_nascimento date, saldo_minimo numeric, nm_agencia character varying)
    RETURNS TABLE(usuario_id bigint, nome_usuario character varying, email_usuario character varying, saldo_conta numeric) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY
    SELECT u.id AS usuario_id, u.nome AS nome_usuario, u.email AS email_usuario, c.saldo AS saldo_conta

    FROM usuarios u

    JOIN contas c ON u.id = c.usuario_id

    JOIN agencias a ON c.agencia_id = a.id

    WHERE u.data_nascimento < TO_DATE(ano_nascimento::TEXT, 'YYYY') AND c.saldo > saldo_minimo AND a.nome_agencia = nm_agencia;
END;
$BODY$;

ALTER FUNCTION public.usuarios_saldo_agencia(date, numeric, character varying)
    OWNER TO postgres;

--SELECT * FROM usuarios_saldo_agencia(1990, 10000, 'Agência Central');--