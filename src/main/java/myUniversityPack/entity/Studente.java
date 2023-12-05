package myUniversityPack.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Studente {
    private String matricola;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String cellulare;
    private Timestamp data_di_nascita;
    private Timestamp data_di_immatricolazione;
    private int id_dipartimento;
    private Credenziali credenziali;
    private List<EsameStudente> esami;

    public Studente() {
    }

    public Studente(String matricola, String nome, String cognome, String indirizzo, String cellulare, Timestamp data_di_nascita, Timestamp data_di_immatricolazione, int id_dipartimento) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.cellulare = cellulare;
        this.data_di_nascita = data_di_nascita;
        this.data_di_immatricolazione = data_di_immatricolazione;
        this.id_dipartimento = id_dipartimento;
        this.esami = new ArrayList<>();
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public Timestamp getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(Timestamp data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public Timestamp getData_di_immatricolazione() {
        return data_di_immatricolazione;
    }

    public void setData_di_immatricolazione(Timestamp data_di_immatricolazione) {
        this.data_di_immatricolazione = data_di_immatricolazione;
    }

    public int getId_dipartimento() {
        return id_dipartimento;
    }

    public void setId_dipartimento(int id_dipartimento) {
        this.id_dipartimento = id_dipartimento;
    }

    public List<EsameStudente> getEsami() {
        return esami;
    }

    public void setEsami(List<EsameStudente> esami) {
        this.esami = esami;
    }

    public Credenziali getCredenziali() {
        return credenziali;
    }

    public void setCredenziali(Credenziali credenziali) {
        this.credenziali = credenziali;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola='" + matricola + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", cellulare='" + cellulare + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", data_di_immatricolazione=" + data_di_immatricolazione +
                ", id_dipartimento=" + id_dipartimento +
                ", credenziali=" + credenziali +
                ", esami=" + esami +
                '}';
    }
}