package pl.edu.pjatk.mpr.springdemo.Models;

public class Autor {
    private Integer id;
    private String imie;
    private String nazwisko;
    private Integer dataur;
    private Integer datasm;

    public Autor(Integer id, String imie, String nazwisko, Integer dataur, Integer datasm) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataur = dataur;
        this.datasm = datasm;
    }

    public Autor(Integer id, String imie, String nazwisko, Integer dataur) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataur = dataur;
    }

    public Autor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Integer getDataur() {
        return dataur;
    }

    public void setDataur(Integer dataur) {
        this.dataur = dataur;
    }

    public Integer getDatasm() {
        return datasm;
    }

    public void setDatasm(Integer datasm) {
        this.datasm = datasm;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataur=" + dataur +
                ", datasm=" + datasm +
                '}';
    }
}
