package myUniversityPack.entity;

public class Esame {

    private int id;
    private String nome;
    private int cfu;
    private int ore_teoria;
    private int ore_laboratorio;
    private int id_dipartimento;

    public Esame() {
    }

    public Esame(int id, String nome, int cfu, int ore_teoria, int ore_laboratorio, int id_dipartimento) {
        this.id = id;
        this.nome = nome;
        this.cfu = cfu;
        this.ore_teoria = ore_teoria;
        this.ore_laboratorio = ore_laboratorio;
        this.id_dipartimento = id_dipartimento;
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

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public int getOre_teoria() {
        return ore_teoria;
    }

    public void setOre_teoria(int ore_teoria) {
        this.ore_teoria = ore_teoria;
    }

    public int getOre_laboratorio() {
        return ore_laboratorio;
    }

    public void setOre_laboratorio(int ore_laboratorio) {
        this.ore_laboratorio = ore_laboratorio;
    }

    public int getId_dipartimento() {
        return id_dipartimento;
    }

    public void setId_dipartimento(int id_dipartimento) {
        this.id_dipartimento = id_dipartimento;
    }

    @Override
    public String toString() {
        return "Esame{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cfu=" + cfu +
                ", ore_teoria=" + ore_teoria +
                ", ore_laboratorio=" + ore_laboratorio +
                ", id_dipartimento=" + id_dipartimento +
                '}';
    }
}
