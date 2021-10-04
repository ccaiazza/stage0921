#1) Visualizzare, per ogni candidato, il cognome, il nome, la data di nascita ed il luogo di nascita
select nome, cognome, data_nascita,luogo_nascita
from persona;

#2) Visualizzare, per ogni candidato, il cognome, il nome, ed il numero di telefono
select nome, cognome, telefono
from persona
where telefono is not null;

/*
3) Visualizzare, per ogni candidato, il cognome, il nome, ed il numero di telefono, includendo
nell’elenco anche i candidati di cui non si conosce il numero di telefono
*/
select nome, cognome, telefono
from persona;

/*
4) Visualizzare, per ogni candidato, i titoli di studio conseguiti, includendo la data, il voto e il
luogo in cui i titoli sono stati conseguiti
*/
select p.nome, p.cognome, p.persona_id, s.tipo,s.data_conseguimento,s.voto,s.luogo_conseguimento
from persona as p
join titoloDiStudio as s on s.studente_id=p.persona_id;

#5) Visualizzare l’elenco dei candidati che hanno conseguito la laurea magistrale
select p.nome, p.cognome,s.tipo
from persona as p
join titoloDiStudio as s on s.studente_id=p.persona_id
where s.tipo='Laurea Magistrale';

#6) Visualizzare i lavori svolti attualmente dai candidati
select p.nome, p.cognome,l.tipo_lavoro
from persona as p
join lavoro as l on l.lavoratore_id=p.persona_id
where l.data_fine_lavoro is null;


#7) Visualizzare l’elenco dei candidati che hanno conseguito la laurea magistrale con un voto maggiore di 100
select p.nome, p.cognome,s.voto
from persona as p
join titoloDiStudio as s on s.studente_id=p.persona_id
where s.tipo='Laurea Magistrale' and s.voto>100;

#8) Visualizzare il voto medio dei candidati
select avg(voto)
from titoloDiStudio;

#9) Visualizzare il numero di lavori effettuato da ogni candidato
select p.nome, p.cognome, count(l.tipo_lavoro) as lavori_effettuati
from persona as p
left join lavoro as l on l.lavoratore_id=p.persona_id
group by p.persona_id;

#10) Visualizzare i candidati che hanno svolto più di un lavoro durante la loro carriera lavorativa
select p.nome, p.cognome, count(tipo_lavoro) as lavori_effettuati
from persona as p
left join lavoro as l on l.lavoratore_id=p.persona_id
group by p.persona_id
having lavori_effettuati>1;

#11) Visualizzare nome e cognome dei candidati che non hanno precedenti esperienze lavorative
select p.nome, p.cognome, count(tipo_lavoro) as lavori_effettuati
from persona as p
left join lavoro as l on l.lavoratore_id=p.persona_id
group by p.persona_id
having lavori_effettuati=0;

#12) Visualizzare nome e cognome dei candidati che hanno almeno due titoli di studio
select p.nome, p.cognome,count(s.tipo) 
from persona as p
join titoloDiStudio as s on s.studente_id=p.persona_id
group by p.persona_id
having count(s.tipo)>=2;

/*
13) Visualizzare un elenco di tutti i nomi e cognomi dei candidati che hanno almeno un’esperienza 
lavorativa (N.B. se il candidato Mario Rossi ha un’esperienza lavorativa, nella tabella risultato 
dovrà apparire una riga con il valore Mario ed una riga con il valore Rossi – Suggerimento: utilizzare l’operatore union
*/

select 'nome' as type, p.nome as persona, p.persona_id,count(tipo_lavoro) as lavori_effettuati
from persona as p
left join lavoro as l on l.lavoratore_id=p.persona_id
group by p.persona_id
having lavori_effettuati>=1
union
select 'cognome' as type, p.cognome as persona,p.persona_id, count(tipo_lavoro) as lavori_effettuati
from persona as p
left join lavoro as l on l.lavoratore_id=p.persona_id
group by p.persona_id
having lavori_effettuati>=1
order by persona_id, type desc;


