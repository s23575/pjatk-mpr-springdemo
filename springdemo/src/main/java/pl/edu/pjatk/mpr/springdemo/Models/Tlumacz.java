package pl.edu.pjatk.mpr.springdemo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

// * GenerationType.Identity – pole ma własną strategię (własną numerację); bez określenia strategii, numeracja
//   jest automatyczna – kontynouowana dla wszystkich obiektów (np. książek i wydań).

// ** CascadeType.All wskazuje, jakie operacje są dozwolone na liście; dzięki temu, dodając do bazy przykładową
//    książkę, można od razu dodać wydanie (listę wydań); nie wyskakuje błąd „object references an unsaved transient
//    instance - save the transient instance before flushing”

@Entity
public class Tlumacz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // To wymaga bezargumentowego konstruktora *
    private Integer id;
    private String imie;
    private String nazwisko;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tlumacze")       // **
    @JsonBackReference       // Adnotacja potrzebna, aby w JSON-ie nie dochodziło do zapętlenia
    private List<Wydanie> wydania;

    public Tlumacz(Integer id, String imie, String nazwisko, List<Wydanie> wydania) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wydania = wydania;
    }

    public Tlumacz() {
    }

    public Integer getId() {
        return id;
    }       // Bez getterów i setterów dane nie będą wyświetlane w JSON-ie

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

    public List<Wydanie> getWydania() {
        return wydania;
    }

    public void setWydania(List<Wydanie> wydania) {
        this.wydania = wydania;
    }

    @Override
    public String toString() {
        return "Tlumacz{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wydania=" + wydania +
                '}';
    }
}
