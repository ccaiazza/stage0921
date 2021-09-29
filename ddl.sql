CREATE DATABASE IF NOT exists Aeroporto_db1
	default character set utf8
    default collate utf8_unicode_ci;
    
USE Aeroporto_db1;
#drop schema aeroporto;

CREATE TABLE IF NOT EXISTS aeroporto (
    aeroporto_id INT,
    città VARCHAR(45) NOT NULL,
    nome VARCHAR(45),
    nazione VARCHAR(45) NOT NULL,
    numero_piste INT,
	PRIMARY KEY (aeroporto_id)
    );
    

CREATE TABLE IF NOT EXISTS aereo (
    aereo_id INT,
    tipo_aereo VARCHAR(10),
    posti_disponibili BIGINT NOT NULL,
    compagnia_appartenenza VARCHAR(45) NOT NULL,
    nome_aereo VARCHAR(45) NOT NULL,
    PRIMARY KEY(aereo_id)
    );


CREATE TABLE IF NOT EXISTS volo (
    codice_volo INT NOT NULL,
    data_partenza VARCHAR(45) NOT NULL,
    data_arrivo VARCHAR(45) NOT NULL,
    numero_passeggeri BIGINT NOT NULL CHECK (numero_passeggeri <= posti_disponibili),
    aeroporto_partenza INT NOT NULL,
    aeroporto_arrivo INT NOT NULL,
    aereo INT NOT NULL,
	PRIMARY KEY (codice_volo),
    FOREIGN KEY (aeroporto_partenza) REFERENCES aeroporto(aeroporto_id),
    FOREIGN KEY (aeroporto_arrivo) REFERENCES aeroporto(aeroporto_id),
    FOREIGN KEY (aereo) REFERENCES aereo(aereo_id) ON DELETE CASCADE
    );
