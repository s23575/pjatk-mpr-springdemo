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
public class Wydanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // To wymaga bezargumentowego konstruktora *
    private Integer id;
    private Integer rok;
    private Integer numer;
    private String isbn;
    private Oprawa oprawa;
    private Double cena;
    private String wydawnictwo;
    private Boolean czyDostepne;
    @ManyToMany(cascade = CascadeType.ALL)      // **
    @JoinTable(
            name = "w_t",
            joinColumns = @JoinColumn(name = "wydanie_id"),
            inverseJoinColumns = @JoinColumn(name = "tlumacz_id"))
    @JsonManagedReference       // Adnotacja potrzebna, aby w JSON-ie nie dochodziło do zapętlenia
    private List<Tlumacz> tlumacze;

    public Wydanie(Integer id, Integer rok, Integer numer, String isbn, Oprawa oprawa, Double cena, String wydawnictwo,
                   Boolean czyDostepne, List<Tlumacz> tlumacze) {
        this.id = id;
        this.rok = rok;
        this.numer = numer;
        this.isbn = isbn;
        this.oprawa = oprawa;
        this.cena = cena;
        this.wydawnictwo = wydawnictwo;
        this.czyDostepne = czyDostepne;
        this.tlumacze = tlumacze;
    }

    public Wydanie() {
    }

    public Integer getId() {
        return id;
    }       // Bez getterów i setterów dane nie będą wyświetlane w JSON-ie

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

    public Boolean getCzyDostepne() {
        return czyDostepne;
    }

    public void setCzyDostepne(Boolean czyDostepne) {
        this.czyDostepne = czyDostepne;
    }

    public List<Tlumacz> getTlumacze() {
        return tlumacze;
    }

    public void setTlumacze(List<Tlumacz> tlumacze) {
        this.tlumacze = tlumacze;
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
                ", czydostepne=" + czyDostepne +
                ", tlumacze=" + tlumacze +
                '}';
    }
}
