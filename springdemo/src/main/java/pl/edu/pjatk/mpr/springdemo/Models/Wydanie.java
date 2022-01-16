package pl.edu.pjatk.mpr.springdemo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Wydanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Do tego potrzebny jest bezargumentowy konstruktor
    private Integer id;
    private Integer rok;
    private Integer numer;
    private String isbn;
    private Oprawa oprawa;
    private Double cena;
    private String wydawnictwo;
    private Boolean czydostepne;
    @ManyToMany
    @JoinTable(
            name = "w_t",
            joinColumns = @JoinColumn(name = "wydanie_id"),
            inverseJoinColumns = @JoinColumn(name = "tlumacz_id"))
    private List<Tlumacz> tlumacz;

    public Wydanie(Integer id, Integer rok, Integer numer, String isbn, Oprawa oprawa, Double cena, String wydawnictwo,
                   Boolean czydostepne, List<Tlumacz> tlumacz) {
        this.id = id;
        this.rok = rok;
        this.numer = numer;
        this.isbn = isbn;
        this.oprawa = oprawa;
        this.cena = cena;
        this.wydawnictwo = wydawnictwo;
        this.czydostepne = czydostepne;
        this.tlumacz = tlumacz;
    }

    public Wydanie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRok() {
        return rok;
    }

    public void setRok(Integer rok) {
        this.rok = rok;
    }

    public Integer getNumer() {
        return numer;
    }

    public void setNumer(Integer numer) {
        this.numer = numer;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Oprawa getOprawa() {
        return oprawa;
    }

    public void setOprawa(Oprawa oprawa) {
        this.oprawa = oprawa;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    public Boolean getCzydostepne() {
        return czydostepne;
    }

    public void setCzydostepne(Boolean czydostepne) {
        this.czydostepne = czydostepne;
    }

    public List<Tlumacz> getTlumacz() {
        return tlumacz;
    }

    public void setTlumacz(List<Tlumacz> tlumacz) {
        this.tlumacz = tlumacz;
    }

    @Override
    public String toString() {
        return "Wydanie{" +
                "id=" + id +
                ", rok=" + rok +
                ", numer=" + numer +
                ", isbn='" + isbn + '\'' +
                ", oprawa=" + oprawa +
                ", cena=" + cena +
                ", wydawnictwo='" + wydawnictwo + '\'' +
                ", czydostepne=" + czydostepne +
                ", tlumacz=" + tlumacz +
                '}';
    }
}
