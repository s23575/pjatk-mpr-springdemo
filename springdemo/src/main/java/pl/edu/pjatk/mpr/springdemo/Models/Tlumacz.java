package pl.edu.pjatk.mpr.springdemo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tlumacz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Do tego potrzebny jest bezargumentowy konstruktor
    private Integer id;
    private String imie;
    private String nazwisko;
    @ManyToMany(mappedBy = "tlumacz")
    private List<Wydanie> wydanie;

    public Tlumacz(Integer id, String imie, String nazwisko, List<Wydanie> wydanie) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wydanie = wydanie;
    }

    public Tlumacz() {
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

    public List<Wydanie> getWydanie() {
        return wydanie;
    }

    public void setWydanie(List<Wydanie> wydanie) {
        this.wydanie = wydanie;
    }

    @Override
    public String toString() {
        return "Tlumacz{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wydanie=" + wydanie +
                '}';
    }
}
