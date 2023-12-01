package myUniversityPack.Entity;

import myUniversityPack.DbUtil.DriverManagerConnectionPool;
import myUniversityPack.EntityService.DatabaseService;

import javax.swing.*;
import java.sql.*;
import java.util.Collection;

public class Studente{
    private int id;
    private String nome;
    private String cognome;
    private Date data_di_nascita;
    private String email;
    private String matricola;
    private int id_dipartimento;
    private int id_credenziali;

    public Studente(String nome, String cognome, Date data_di_nascita, String email, String matricola, int id_dipartimento, int id_credenziali) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
        this.email = email;
        this.matricola = matricola;
        this.id_dipartimento = id_dipartimento;
        this.id_credenziali = id_credenziali;
    }

    public Studente(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(Date data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public int getId_dipartimento() {
        return id_dipartimento;
    }

    public void setId_dipartimento(int id_dipartimento) {
        this.id_dipartimento = id_dipartimento;
    }

    public int getId_credenziali() {
        return id_credenziali;
    }

    public void setId_credenziali(int id_credenziali) {
        this.id_credenziali = id_credenziali;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", email='" + email + '\'' +
                ", matricola='" + matricola + '\'' +
                ", id_dipartimento=" + id_dipartimento +
                ", id_credenziali=" + id_credenziali +
                '}';
    }
}
