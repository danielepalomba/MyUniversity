package myUniversityPack.Entity;

public class EsameStudente {

    private int id;
    private String matricola_studente;
    private int id_esame;

    public EsameStudente() {
    }

    public EsameStudente(String matricola_studente, int id_esame) {
        this.matricola_studente = matricola_studente;
        this.id_esame = id_esame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricola_studente() {
        return matricola_studente;
    }

    public void setMatricola_studente(String matricola_studente) {
        this.matricola_studente = matricola_studente;
    }

    public int getId_esame() {
        return id_esame;
    }

    public void setId_esame(int id_esame) {
        this.id_esame = id_esame;
    }

    @Override
    public String toString() {
        return "EsameStudente{" +
                "id=" + id +
                ", matricola_studente='" + matricola_studente + '\'' +
                ", id_esame=" + id_esame +
                '}';
    }
}
