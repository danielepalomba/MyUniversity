## Specifica di Progetto: Sistema Informativo Accademico

### Descrizione
Il progetto mira a modellare una base di dati per supportare uno strumento informativo dedicato agli studenti, consentendo la gestione efficace dei loro dati accademici.

### Entità e Attributi

#### Studente
- `id` (identificativo unico)
- `nome`
- `cognome`
- `data di nascita`
- `Email`
- `matricola`

#### Dipartimento
- `codice` (identificativo unico)
- `nome`
- `locazione`

#### Credenziali
- `id` (identificativo unico)
- `username`
- `password`

#### Esame
- `id` (identificativo unico)
- `nome`
- `cfu` (Crediti Formativi Universitari)
- `votazione`

### Relazioni
- Uno studente è associato ad uno e solo uno specifico dipartimento.
- Ogni studente è associato a un insieme univoco di credenziali.
- Uno studente può aver sostenuto da zero a più esami.
- Ogni esame è associato al dipartimento di riferimento.

### Note Aggiuntive
- Gli esami sono legati ai dipartimenti ai quali appartengono.
- Le credenziali identificano univocamente uno studente.
- Ogni studente può avere un elenco variabile di esami sostenuti.
