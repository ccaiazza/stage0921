#1. Le città con un aeroporto di cui non è noto il numero di piste;

#SELECT nome, città
SELECT *
FROM aeroporto
WHERE numero_piste IS NULL;


#2 Le nazioni da cui parte e arriva il volo con codice 1;

SELECT AP.nazione AS nazione_partenza, AA.nazione AS nazione_arrivo
FROM volo AS V
JOIN aeroporto AP ON AP.aeroporto_id = V.aeroporto_partenza
JOIN aeroporto AA ON AA.aeroporto_id = V.aeroporto_arrivo
WHERE V.codice_volo = 1;


#3. I tipi di aereo usati nei voli che partono da Roma;

SELECT tipo_aereo, AP.città
FROM aereo AS A
JOIN volo AS V ON V.aereo = A.aereo_id 
JOIN aeroporto as AP ON AP.aeroporto_id = V.aeroporto_partenza
WHERE città='ROMA';


#4. I tipi di aereo e il corrispondente numero di passeggeri per i voli che partono da Roma.

SELECT tipo_aereo, V.data_partenza, V.numero_passeggeri, V.aeroporto_partenza, V.aeroporto_arrivo
FROM aereo AS A, aeroporto AS Ar, volo AS V 
WHERE V.aereo = A.aereo_id 
AND Ar.aeroporto_id = V.aeroporto_partenza
AND città='ROMA';


#5. Le città da cui partono voli diretti ad Amsterdam, ordinate alfabeticamente;

SELECT DISTINCT AP.città AS città_partenza, AA.città AS città_arrivo
FROM volo AS V
JOIN aeroporto AP ON AP.aeroporto_id = V.aeroporto_partenza
JOIN aeroporto AA ON AA.aeroporto_id = V.aeroporto_arrivo
WHERE AA.città = 'Amsterdam'
ORDER BY AP.città;
 

#6. Il numero di voli che partono il venerdì da Napoli;

SELECT Ar.città, COUNT(Ar.città)
FROM aeroporto as Ar, volo as V
WHERE Ar.città = 'Napoli' AND V.aeroporto_partenza = Ar.aeroporto_id
AND DATE_FORMAT(V.data_partenza, ' %W %M %D %Y') LIKE ' Friday %';

#7. Le città italiane da cui partono almeno 2 voli alla settimana diretti in Olanda;           

SELECT WEEK(V.data_partenza) AS partenza, COUNT(V.data_partenza),
AP.città AS città_partenza, AA.città AS città_arrivo, AA.nazione, V.codice_volo
FROM volo AS V
JOIN aeroporto AP ON AP.aeroporto_id = V.aeroporto_partenza
JOIN aeroporto AA ON AA.aeroporto_id = V.aeroporto_arrivo
WHERE AA.nazione = 'Paesi Bassi' AND AP.nazione= 'Italia'
GROUP BY partenza, città_partenza
HAVING count(V.data_partenza) > 1
ORDER BY città_partenza;


#8. Le città da cui parte l'aereo caratterizzato dal massimo numero di passeggeri;

SELECT AP.città
FROM Volo AS V, Aereo AS A, Aeroporto AS AP
WHERE AP.aeroporto_id=V.aeroporto_partenza AND V.aereo=A.aereo_id
AND V.numero_passeggeri= (select max(numero_passeggeri) from Volo);

#9. Le città su cui è diretto l'aereo caratterizzato dal massimo numero di passeggeri;

SELECT AA.città
FROM Volo AS V, Aereo AS A, Aeroporto AS AA
WHERE AA.aeroporto_id=V.aeroporto_arrivo AND V.aereo=A.aereo_id
AND V.numero_passeggeri= (select max(numero_passeggeri) from Volo);

#10. Le città che sono servite dall'aereo caratterizzato dal massimo numero di passeggeri;

SELECT AP.città, AA.città, A.aereo_id
FROM aereo as A, volo AS V
JOIN aeroporto AP ON AP.aeroporto_id = V.aeroporto_partenza
JOIN aeroporto AA ON AA.aeroporto_id = V.aeroporto_arrivo
WHERE V.aereo = A.aereo_id
AND V.aereo = (
		SELECT A.aereo_id
		FROM aereo AS A
		WHERE A.posti_disponibili = (
				SELECT MAX(posti_disponibili) 
                FROM aereo
		)
	);
