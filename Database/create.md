# MyUniversity DB
```
DROP DATABASE IF EXISTS MyUniversity;

CREATE DATABASE MyUniversity;

USE MyUniversity;

CREATE TABLE Studente (
    id INT PRIMARY KEY,
    nome VARCHAR(50),
    cognome VARCHAR(50),
    data_di_nascita DATE,
    Email VARCHAR(100),
    matricola VARCHAR(20),
    id_dipartimento INT,
    id_credenziali INT,
    FOREIGN KEY (id_dipartimento) REFERENCES Dipartimento(codice),
    FOREIGN KEY (id_credenziali) REFERENCES Credenziali(id)
);

CREATE TABLE Dipartimento (
    codice INT PRIMARY KEY,
    nome VARCHAR(50),
    locazione VARCHAR(100)
);

CREATE TABLE Credenziali (
    id INT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    UNIQUE (username)
);

CREATE TABLE Esame (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    cfu INT,
    votazione DECIMAL(3, 1),
    id_dipartimento INT,
    data_svolgimento DATE,
    anno INT,
    semestre INT,
    FOREIGN KEY (id_dipartimento) REFERENCES Dipartimento(codice)
);
```
