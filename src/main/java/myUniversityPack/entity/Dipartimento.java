package myUniversityPack.entity;

import java.util.List;

public class Dipartimento {

    private int id;
    private String nome;
    private String edificio;
    private List<Esame> esami;

    public Dipartimento() {
    }

    public Dipartimento(String nome, String edificio) {
        this.nome = nome;
        this.edificio = edificio;
    }

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

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public List<Esame> getEsami() {
        return esami;
    }

    public void setEsami(List<Esame> esami) {
        this.esami = esami;
    }

    @Override
    public String toString() {
        return "Dipartimento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", edificio='" + edificio + '\'' +
                ", esami=" + esami +
                '}';
    }
}
