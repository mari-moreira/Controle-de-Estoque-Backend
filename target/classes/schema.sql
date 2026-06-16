CREATE DATABASE IF NOT EXISTS controle_estoque;
USE controle_estoque;

CREATE TABLE IF NOT EXISTS fornecedor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cnpj VARCHAR(20),
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    cidade VARCHAR(100),
    produto_fornecido_a VARCHAR(100),
    produto_fornecido_b VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(20),
    telefone VARCHAR(20),
    endereco VARCHAR(255)
);