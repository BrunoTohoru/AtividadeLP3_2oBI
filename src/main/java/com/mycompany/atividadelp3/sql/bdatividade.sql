CREATE DATABASE IF NOT EXISTS ifpr;

USE ifpr;

CREATE TABLE IF NOT EXISTS estilo (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL DEFAULT "Não registrado.",
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS filme (
    id INT NOT NULL AUTO_INCREMENT,
    estilo_id INT NOT NULL,
    nome VARCHAR(100) NOT NULL DEFAULT "Não informado.",
    ano VARCHAR(4) NOT NULL DEFAULT "N/A",
    duracao INT NOT NULL DEFAULT 0,
    foto VARCHAR(200) NOT NULL DEFAULT "Caminho do arquivo não informado",
    sinopse VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (estilo_id) REFERENCES estilo(id)
);

CREATE TABLE IF NOT EXISTS cliente (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL DEFAULT "Não informado.",
    endereco VARCHAR(120),
    telefone VARCHAR(30) NOT NULL DEFAULT "Não informado",
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS locacao (
    id INT NOT NULL AUTO_INCREMENT,
    filme_id INT NOT NULL,
    cliente_id INT NOT NULL,
    emissao DATE NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    devolucao DATE NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    valor DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (filme_id) REFERENCES filme(id),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
