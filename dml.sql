INSERT INTO persona (persona_id, cognome, nome, data_nascita, indirizzo, città, luogo_nascita, telefono)
VALUES
  ('STEMAR93','Steria','Mario','1993-09-13','Via Strada alberata','Milano','Ragusa',391401792132),
  ('STAFRA95','Staiano','Francesca','1995-11-16','Via Roma','Ragusa','Napoli',396338834571),
  ('COLROB95','Colombo','Roberto','1995-11-13','Via Crucis','Padova','Padova',396536385002),
  ('ROMROB90','Romano','Roberto','1990-07-14','Via Stazione','Milano','Brescia',392770543415),
  ('COLATT98','Colombo','Attilio','1998-02-21','Via Università','Taranto','Cosenza',NULL),
  ('ROSSYR91','Rossi','Syria','1991-11-09','Via Bellavita','Reggio Emilia','Messina',394831360203),
  ('INGCORR91','Inglese','Corrado','1994-12-25','Via Toledo','Reggio Emilia','Milano',392113451806),
  ('BIAGIU91','Bianchi','Giuseppe','1991-03-09','Via Crucis','Cosenza','Palermo',392036232322),
  ('MACSIM94','Macrì','Simone','1994-06-23','Piazza Poli','Caserta','Cagliari',398055290933),
  ('RIOALE92','Rione','Alessio','1992-10-29','Via Stazione','Ragusa','Napoli',392600708867),

  ('TORANN98','Torelli','Annamaria','1998-09-24','Via Leonardo Da Vinci','Genova','Napoli',397405777206),
  ('RICROS96','Ricci','Rosa','1996-08-29','Via Pomponio Gaurico','Venenia','Bari',399895913611),
  ('ESPSAL98','Esposito','Salvatore','1998-05-10','Via Soprasteria','Palermo','Taranto',396274230332),
  ('LIOILA94','Lione','Ilaria','1994-10-21','Piazza Poli','Bari','Padova',399392504308),
  ('COLGRE97','Colombo','Greta','1997-06-06','Piazza San Ciro','Brescia','Padova',396536645850),
  ('RUSROB92','Russo','Roberto','1992-10-28','Via Roma','Cagliari','Cagliari',393877690082),
  ('FERALI92','Ferrara','Alice','1992-08-22','Via Crucis','Venenia','Milano',396653153217),
  ('BIAGAB93','Bianchi','Gabrilele','1993-09-11','Via Toledo','Firenze','Padova',397847790726),
  ('COLMAR90B','Colombo','Mario','1990-11-20','Piazza Gravia','Brescia','Genova',394150832933),
  ('DENGIU94','Denaro','Giuseppe','1994-06-29','Via Leonardo Da Vinci','Taranto','Roma',399795238190);


INSERT INTO lavoro (lavoro_id,tipo_lavoro,data_inzio_lavoro,data_fine_lavoro,lavoratore_id)
VALUES
  (1,'programmatore informatico','2018-12-15','2019-10-14','STEMAR93'),
  (2,'cameriere','2019-09-17','2020-06-26','STAFRA95'),
  (3,'personal trainer','2020-09-26',NULL,'COLROB95'),
  (4,'interprete','2018-03-13','2019-09-15','ROMROB90'),
  (5,'ingegnere civile','2021-04-07','2021-04-26','MACSIM94'),
  (6,'personal trainer','2018-10-14','2021-07-26','ROSSYR91'),
  (7,'docente','2018-11-09','2020-04-10','COLROB95'),
  (8,'programmatore informatico','2020-05-23','2021-03-25','COLATT98'),
  (9,'ingegnere civile','2020-06-14','2021-04-11','STEMAR93'),
  (10,'ingegnere civile','2021-05-16',NULL,'MACSIM94'),
  (11,'ingegnere civile','2018-12-09','2020-07-06','INGCORR91'),
  (12,'cameriere','2021-07-21',NULL,'TORANN98'),
  (13,'cameriere','2018-07-24','2019-11-17','BIAGIU91'),
  (14,'ingegnere civile','2021-08-02','2021-09-22','RIOALE92'),
  (15,'cameriere','2020-08-31','2021-03-28','RIOALE92'),
  (16,'programmatore informatico','2018-09-27','2020-08-18','RICROS96'),
  (17,'programmatore informatico','2010-10-08','2021-02-07','RICROS96'),
  (18,'programmatore informatico','2020-06-23','2021-08-26','BIAGIU91'),
  (19,'personal trainer','2019-05-17','2021-06-21','ESPSAL98'),
  (20,'ingegnere civile','2019-08-30','2020-08-04','LIOILA94');
  


insert into titoloDiStudio (id_titoloDiStudio, tipo, voto, data_conseguimento, luogo_conseguimento, studente_id)
values 
(1,'Diploma',90,'2010-07-08','Avellino','STAFRA95'),
(2,'Laurea Triennale',100,'2010-07-08','Salerno','STAFRA95'),
(3,'Laurea Magistrale',101,'2010-07-08','Salerno','STAFRA95'),
(4,'Laurea Triennale',99,'2012-07-10','Napoli','COLROB95'),
(5,'Diploma',90,'2010-07-08','Napoli','COLROB95'),
(6,'Laurea Magistrale',105,'2010-07-08','Napoli','LIOILA94');