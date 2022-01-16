package pl.edu.pjatk.mpr.springdemo.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ksiazka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Do tego potrzebny jest bezargumentowy konstruktor
    // Identity sprawia, że dane pole ma swoją własną strategię (nie ma wspólnej numeracji dla np. książek i wydań)
    private Integer id;
    private String tytul;
    private String tytuloryg;
    @OneToMany(cascade = CascadeType.ALL)
    // To służy "powiedzeniu", jakie operacje są dozwolone na liście, przez to nie wyskakuje błąd
    // "object references an unsaved transient instance - save the transient instance before flushing"
    // Dzięki temu przez stworzenie (dodanie do bazy) przykładowej książki można od razu dodać listę wydań
    @JoinTable(
            name = "k_w",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "wydanie_id"))
    private List<Wydanie> wydanie;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "k_a",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    @JsonManagedReference
    // Ta adnotacja jest potrzebna, żeby w JSONie książka nie rozwijała się bez końca (zapętlenie)
    private List<Autor> autorzy;

    public Ksiazka(Integer id, String tytul, String tytuloryg, List<Wydanie> wydanie, List<Autor> autorzy) {
        this.id = id;
        this.tytul = tytul;
        this.tytuloryg = tytuloryg;
        this.wydanie = wydanie;
        this.autorzy = autorzy;
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

    public List<Autor> getAutorzy() {
        return autorzy;
    }

    public void setAutorzy(List<Autor> autorzy) {
        this.autorzy = autorzy;
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", tytuloryg='" + tytuloryg + '\'' +
                ", wydanie=" + wydanie +
                ", autorzy=" + autorzy +
                '}';
    }
}
