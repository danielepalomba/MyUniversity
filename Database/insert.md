# VALUES TO INSERT


### Inserimento dipartimenti
```
-- Inserimento di dipartimenti
INSERT INTO DIPARTIMENTO (NOME, EDIFICIO) VALUES ('Informatica', 'Edificio A');
INSERT INTO DIPARTIMENTO (NOME, EDIFICIO) VALUES ('Matematica', 'Edificio B');
INSERT INTO DIPARTIMENTO (NOME, EDIFICIO) VALUES ('Fisica', 'Edificio C');
INSERT INTO DIPARTIMENTO (NOME, EDIFICIO) VALUES ('Chimica', 'Edificio D');
INSERT INTO DIPARTIMENTO (NOME, EDIFICIO) VALUES ('Lingue', 'Edificio E');
```

### Inserimento esami associati ai dipartimenti
```
-- Inserimento di esami associati ai dipartimenti
INSERT INTO ESAME (NOME, CFU, ORE_TEORIA, ORE_LABORATORIO, ID_DIPARTIMENTO) VALUES ('Programmazione', 6, 60, 40, 1);
INSERT INTO ESAME (NOME, CFU, ORE_TEORIA, ORE_LABORATORIO, ID_DIPARTIMENTO) VALUES ('Algebra Lineare', 8, 70, 30, 2);
INSERT INTO ESAME (NOME, CFU, ORE_TEORIA, ORE_LABORATORIO, ID_DIPARTIMENTO) VALUES ('Meccanica Quantistica', 7, 80, 20, 3);
INSERT INTO ESAME (NOME, CFU, ORE_TEORIA, ORE_LABORATORIO, ID_DIPARTIMENTO) VALUES ('Chimica Organica', 5, 50, 50, 4);
INSERT INTO ESAME (NOME, CFU, ORE_TEORIA, ORE_LABORATORIO, ID_DIPARTIMENTO) VALUES ('Lingua Inglese', 4, 40, 60, 5);
```

### Inserimento studenti associati ai dipartimenti
```
-- Inserimento di studenti associati ai dipartimenti
INSERT INTO STUDENTE (MATRICOLA, NOME, COGNOME, INDIRIZZO, CELLULARE, DATA_DI_NASCITA, DATA_IMMATRICOLAZIONE, ID_DIPARTIMENTO) VALUES ('1234567890', 'Mario', 'Rossi', 'Via Roma 1', '1234567890', '2000-01-15', '2021-09-01', 1);
INSERT INTO STUDENTE (MATRICOLA, NOME, COGNOME, INDIRIZZO, CELLULARE, DATA_DI_NASCITA, DATA_IMMATRICOLAZIONE, ID_DIPARTIMENTO) VALUES ('2345678901', 'Anna', 'Bianchi', 'Via Milano 2', '2345678901', '1999-05-20', '2020-10-05', 2);
INSERT INTO STUDENTE (MATRICOLA, NOME, COGNOME, INDIRIZZO, CELLULARE, DATA_DI_NASCITA, DATA_IMMATRICOLAZIONE, ID_DIPARTIMENTO) VALUES ('3456789012', 'Luca', 'Verdi', 'Via Firenze 3', '3456789012', '2001-12-10', '2022-03-15', 3);
INSERT INTO STUDENTE (MATRICOLA, NOME, COGNOME, INDIRIZZO, CELLULARE, DATA_DI_NASCITA, DATA_IMMATRICOLAZIONE, ID_DIPARTIMENTO) VALUES ('4567890123', 'Giulia', 'Neri', 'Via Venezia 4', '4567890123', '2002-08-05', '2023-01-20', 4);
INSERT INTO STUDENTE (MATRICOLA, NOME, COGNOME, INDIRIZZO, CELLULARE, DATA_DI_NASCITA, DATA_IMMATRICOLAZIONE, ID_DIPARTIMENTO) VALUES ('5678901234', 'Alessandro', 'Gialli', 'Via Torino 5', '5678901234', '2000-04-25', '2021-11-11', 5);
```

### Inseriemento credenziali relative a studente
```
-- Inserimento di credenziali degli studenti
INSERT INTO CREDENZIALI (USERNAME, PASSWORD, MATRICOLA_STUDENTE) VALUES ('mario123', 'marioPassword', '1234567890');
INSERT INTO CREDENZIALI (USERNAME, PASSWORD, MATRICOLA_STUDENTE) VALUES ('anna2000', 'annaPassword', '2345678901');
INSERT INTO CREDENZIALI (USERNAME, PASSWORD, MATRICOLA_STUDENTE) VALUES ('luca3456', 'lucaPassword', '3456789012');
INSERT INTO CREDENZIALI (USERNAME, PASSWORD, MATRICOLA_STUDENTE) VALUES ('giulia01', 'giuliaPassword', '4567890123');
INSERT INTO CREDENZIALI (USERNAME, PASSWORD, MATRICOLA_STUDENTE) VALUES ('alessandro5', 'alessandroPassword', '5678901234');
```

### Inserimento esami a singoli studenti
```
-- Chiamata alla procedura per l'aggiunta di relazioni studente-esame rispettando i dipartimenti
CALL AggiungiStudenteEsame('1234567890', 1); -- Mario iscritto a Programmazione
CALL AggiungiStudenteEsame('2345678901', 2); -- Anna iscritta ad Algebra Lineare
CALL AggiungiStudenteEsame('3456789012', 3); -- Luca iscritto a Meccanica Quantistica
CALL AggiungiStudenteEsame('4567890123', 4); -- Giulia iscritta a Chimica Organica
CALL AggiungiStudenteEsame('5678901234', 5); -- Alessandro iscritto a Lingua Inglese
```


