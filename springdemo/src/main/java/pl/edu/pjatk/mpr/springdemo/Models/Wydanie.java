package pl.edu.pjatk.mpr.springdemo.Models;

public class Wydanie {
    private Integer id;
    private Integer rok;
    private Integer numer;
    private String isbn;
    private Oprawa oprawa;
    private Double cena;
    private String wydawnictwo;
    private Boolean czydostepne;

    public Wydanie(Integer id, Integer rok, Integer numer, String isbn, Oprawa oprawa, Double cena, String wydawnictwo,
                   Boolean czydostepne) {
        this.id = id;
        this.rok = rok;
        this.numer = numer;
        this.isbn = isbn;
        this.oprawa = oprawa;
        this.cena = cena;
        this.wydawnictwo = wydawnictwo;
        this.czydostepne = czydostepne;
    }

    public Wydanie(Integer id, Integer rok, String isbn, Oprawa oprawa, Double cena, String wydawnictwo, Boolean czydostepne) {
        this.id = id;
        this.rok = rok;
        this.isbn = isbn;
        this.oprawa = oprawa;
        this.cena = cena;
        this.wydawnictwo = wydawnictwo;
        this.czydostepne = czydostepne;
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
                '}';
    }
}
