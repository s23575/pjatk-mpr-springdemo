package pl.edu.pjatk.mpr.springdemo.Models;

import java.util.List;

public class Ksiazka {
    private Integer id;
    private String tytul;
    private String tytuloryg;
    private List<Wydanie> wydanie;

    public Ksiazka(Integer id, String tytul, String tytuloryg, List<Wydanie> wydanie) {
        this.id = id;
        this.tytul = tytul;
        this.tytuloryg = tytuloryg;
        this.wydanie = wydanie;
    }

    public Ksiazka(Integer id, String tytul, List<Wydanie> wydanie) {
        this.id = id;
        this.tytul = tytul;
        this.wydanie = wydanie;
    }

    public Ksiazka() {
    }

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

    @Override
    public String toString() {
        return "Ksiazka{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", tytuloryg='" + tytuloryg + '\'' +
                ", wydanie=" + wydanie +
                '}';
    }
}
