CREATE DATABASE IF NOT exists cv
default character set utf8
default collate utf8_unicode_ci;

USE cv;
#drop schema aeroporto;

CREATE TABLE IF NOT EXISTS persona (

persona_id VARCHAR(45) PRIMARY KEY,
cognome VARCHAR(45) NOT NULL,
nome VARCHAR(45),
data_nascita DATE,
indirizzo VARCHAR(45) NOT NULL,
città VARCHAR(45),
luogo_nascita VARCHAR(45) NOT NULL,
telefono bigint
);



CREATE TABLE IF NOT EXISTS titoloDiStudio(
id_titoloDiStudio INT PRIMARY KEY,
tipo ENUM('5° Elementare','Terza media','Diploma','Laurea Triennale','Laurea Magistrale'),
voto INT,
data_conseguimento DATE,
luogo_conseguimento VARCHAR(10),
studente_id VARCHAR(45),
FOREIGN KEY(studente_id) REFERENCES persona(persona_id)
);



CREATE TABLE IF NOT EXISTS lavoro(
lavoro_id INT PRIMARY KEY,
tipo_lavoro VARCHAR(100),
data_inzio_lavoro DATE,
data_fine_lavoro DATE,
lavoratore_id VARCHAR(45),
FOREIGN KEY(lavoratore_id) REFERENCES persona(persona_id)
); 


