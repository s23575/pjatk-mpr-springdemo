package pl.edu.pjatk.mpr.springdemo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Do tego potrzebny jest bezargumentowy konstruktor
    private Integer id;
    private String imie;
    private String nazwisko;
    private Integer dataur;
    private Integer datasm;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "autorzy")
    @JsonBackReference
    // Ta adnotacja jest potrzebna, żeby w JSONie książka nie rozwijała się bez końca (zapętlenie)
    private List<Ksiazka> ksiazka;

    public Autor(Integer id, String imie, String nazwisko, Integer dataur, Integer datasm, List<Ksiazka> ksiazka) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataur = dataur;
        this.datasm = datasm;
        this.ksiazka = ksiazka;
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

    public List<Ksiazka> getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(List<Ksiazka> ksiazka) {
        this.ksiazka = ksiazka;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataur=" + dataur +
                ", datasm=" + datasm +
                ", ksiazka=" + ksiazka +
                '}';
    }
}
