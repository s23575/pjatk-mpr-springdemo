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
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // To wymaga bezargumentowego konstruktora *
    private Integer id;
    private String imie;
    private String nazwisko;
    @Column(name = "data_ur")
    private Integer dataUr;
    @Column(name = "data_sm")
    private Integer dataSm;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "autorzy")        // **
    @JsonBackReference      // Adnotacja potrzebna, aby w JSON-ie nie dochodziło do zapętlenia
    private List<Ksiazka> ksiazki;

    public Autor(Integer id, String imie, String nazwisko, Integer dataUr, Integer dataSm, List<Ksiazka> ksiazki) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
        this.dataSm = dataSm;
        this.ksiazki = ksiazki;
    }

    public Autor() {
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

    public Integer getDataUr() {
        return dataUr;
    }

    public void setDataUr(Integer dataUr) {
        this.dataUr = dataUr;
    }

    public Integer getDataSm() {
        return dataSm;
    }

    public void setDataSm(Integer dataSm) {
        this.dataSm = dataSm;
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataur=" + dataUr +
                ", datasm=" + dataSm +
                ", ksiazka=" + ksiazki +
                '}';
    }
}
