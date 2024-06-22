DELIMITER //

CREATE FUNCTION CartoesCreditoVencimento()
RETURNS TABLE (
    id BIGINT,
    conta_id BIGINT,
    numero_cartao VARCHAR(20),
    tipo_cartao VARCHAR(50),
    limite DECIMAL(15, 2),
    validade DATE
)
BEGIN
    RETURN (
        SELECT *
        FROM cartoes
        WHERE tipo_cartao = 'crédito'
          AND limite = 6000
          AND validade BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 30 DAY)
    );
END //

DELIMITER ;
GO 

/*CALL CartoesCreditoVencimento();*/


DELIMITER //

CREATE PROCEDURE Top3AgenciasDepositos2024()
BEGIN
    SELECT 
        a.id AS agencia_id, 
        a.nome AS nome_agencia, 
        COUNT(t.id) AS total_depositos

    FROM transacoes t

    JOIN agencias a ON t.agencia_id = a.id

    JOIN tipos_transacoes tt ON t.tipo_transacao_id = tt.id

    WHERE tt.nome = 'deposito' AND YEAR(t.data_transacao) = 2024

    GROUP BY a.id, a.nome

    ORDER BY total_depositos DESC
    LIMIT 3;
END //

DELIMITER ;
GO

/*CALL Top3AgenciasDepositos2024();*/


DELIMITER //

CREATE FUNCTION UsuariosSaldoNegativoAntes1990()
RETURNS TABLE (
    id BIGINT,
    nome VARCHAR(100),
    data_nascimento DATE,
    saldo NUMERIC(15, 2)
)
BEGIN
    RETURN (
        SELECT 
            u.id,
            u.nome,
            u.data_nascimento,
            c.saldo
        FROM usuarios u

        JOIN contas c ON u.id = c.usuario_id

        JOIN agencias a ON c.agencia_id = a.id AND a.nome = 'Agência Central'

        JOIN historico_saldos hs ON c.id = hs.conta_id

        WHERE u.data_nascimento < '1990-01-01'AND hs.saldo < 0  
    );
END //

DELIMITER ;

/*SELECT * FROM UsuariosSaldoNegativoAntes1990();*/


DELIMITER //

CREATE PROCEDURE ContasCorrenteNascidosDepois1990()
BEGIN
    SELECT 
        c.id AS conta_id,
        c.tipo_conta,
        c.saldo,
        u.id AS usuario_id,
        u.nome AS usuario_nome,
        u.data_nascimento
    FROM 
        contas c
    JOIN 
        usuarios u ON c.usuario_id = u.id
    WHERE 
        c.tipo_conta = 'corrente'
        AND u.data_nascimento > '1990-12-31';  -- Considerando data de nascimento após 31 de dezembro de 1990
END //

DELIMITER ;

/*CALL ContasCorrenteNascidosDepois1990();*/