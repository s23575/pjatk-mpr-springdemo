package pl.edu.pjatk.mpr.springdemo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ksiazka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Do tego potrzebny jest bezargumentowy konstruktor
    private Integer id;
    private String tytul;
    private String tytuloryg;
    @OneToMany
    @JoinTable(
            name = "k_w",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "wydanie_id"))
    private List<Wydanie> wydanie;
    @ManyToMany
    @JoinTable(
            name = "k_a",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autor;

    public Ksiazka(Integer id, String tytul, String tytuloryg, List<Wydanie> wydanie, List<Autor> autor) {
        this.id = id;
        this.tytul = tytul;
        this.tytuloryg = tytuloryg;
        this.wydanie = wydanie;
        this.autor = autor;
    }

    public Ksiazka() {
    }

    // Bez getterów i setterów dane nie będą wyświetlane w aplikacji / JSONie
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTytuloryg() {
        return tytuloryg;
    }

    public void setTytuloryg(String tytuloryg) {
        this.tytuloryg = tytuloryg;
    }


    public List<Wydanie> getWydanie() {
        return wydanie;
    }

    public void setWydanie(List<Wydanie> wydanie) {
        this.wydanie = wydanie;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", tytuloryg='" + tytuloryg + '\'' +
                ", wydanie=" + wydanie +
                ", autor=" + autor +
                '}';
    }
}
