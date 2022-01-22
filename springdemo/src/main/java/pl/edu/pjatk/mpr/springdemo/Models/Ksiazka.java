package pl.edu.pjatk.mpr.springdemo.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

// * GenerationType.Identity – pole ma własną strategię (własną numerację); bez określenia strategii, numeracja
//   jest automatyczna – kontynouowana dla wszystkich obiektów (np. książek i wydań).

// ** CascadeType.All wskazuje, jakie operacje są dozwolone na liście; dzięki temu, dodając do bazy przykładową
//    książkę, można od razu dodać wydanie (listę wydań); nie wyskakuje błąd „object references an unsaved transient
//    instance - save the transient instance before flushing”

@Entity
public class Ksiazka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // To wymaga bezargumentowego konstruktora *
    private Integer id;
    private String tytul;
    @Column(name = "tytul_oryg")
    private String tytulOryg;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "k_w",
            joinColumns = @JoinColumn(name = "ksiazka_id")/*,
            inverseJoinColumns = @JoinColumn(name = "wydanie_id")*/)
    private List<Wydanie> wydania;
    @ManyToMany(cascade = CascadeType.ALL)      // **
    @JoinTable(
            name = "k_a",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    @JsonManagedReference       // Adnotacja potrzebna, aby w JSON-ie nie dochodziło do zapętlenia
    private List<Autor> autorzy;

    public Ksiazka(Integer id, String tytul, String tytulOryg, List<Wydanie> wydania, List<Autor> autorzy) {
        this.id = id;
        this.tytul = tytul;
        this.tytulOryg = tytulOryg;
        this.wydania = wydania;
        this.autorzy = autorzy;
    }

    public Ksiazka() {
    }

    public Integer getId() {
        return id;
    }       // Bez getterów i setterów dane nie będą wyświetlane w JSON-ie


    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTytulOryg() {
        return tytulOryg;
    }

    public void setTytulOryg(String tytulOryg) {
        this.tytulOryg = tytulOryg;
    }

    public List<Wydanie> getWydania() {
        return wydania;
    }

    public void setWydania(List<Wydanie> wydania) {
        this.wydania = wydania;
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
                ", tytuloryg='" + tytulOryg + '\'' +
                ", wydania=" + wydania +
                ", autorzy=" + autorzy +
                '}';
    }
}
