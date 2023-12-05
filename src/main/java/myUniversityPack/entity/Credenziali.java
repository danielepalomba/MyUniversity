package myUniversityPack.entity;

public class Credenziali {

    private int id;
    private String username;
    private String password;
    private String matricola_studente;

    public Credenziali() {
    }

    public Credenziali(String username, String password, String matricola_studente) {
        this.username = username;
        this.password = password;
        this.matricola_studente = matricola_studente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatricola_studente() {
        return matricola_studente;
    }

    public void setMatricola_studente(String matricola_studente) {
        this.matricola_studente = matricola_studente;
    }

    @Override
    public String toString() {
        return "Credenziali{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", matricola_studente='" + matricola_studente + '\'' +
                '}';
    }
}

