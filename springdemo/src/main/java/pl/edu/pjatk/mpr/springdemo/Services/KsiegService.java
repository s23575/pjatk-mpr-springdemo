package pl.edu.pjatk.mpr.springdemo.Services;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.mpr.springdemo.Models.*;
import pl.edu.pjatk.mpr.springdemo.Repositories.AutorRepository;
import pl.edu.pjatk.mpr.springdemo.Repositories.KsiazkaRepository;
import pl.edu.pjatk.mpr.springdemo.Repositories.TlumaczRepository;
import pl.edu.pjatk.mpr.springdemo.Repositories.WydanieRepository;

import java.util.List;
import java.util.Optional;

// * Wstrzynięcie można zrobić przez „Autowired” – jak w przypadku kontrolera i serwisu

// ** „findById” domyślnie zwraca typ „Optional<T>”; to widać w (kliknięcie + CTRL) „KsiazkaRepository” ->
//    „JpaRepository” -> „PagingAndSortingRepository” -> „CrudRepository”

// *** „byId.” oferuje wiele różnych opcji, co w sytuacji, gdy szukana wartość nie zostanie znaleziona – gdy zwrócony
//     zostanie inny obiekt („zwróć mi obiekt taki, a jak go nie ma, to...”); „RuntimeException” zwraca w aplikacji
//     błąd o statusie 500 („Internal Server Error”).

@Service        // Po dodaniu tej adnotacji, klasa jest odpowiednio „widziana” przez Springa („używana”)
public class KsiegService {

    private final KsiazkaRepository ksiazkaRepository;
    private final WydanieRepository wydanieRepository;
    private final AutorRepository autorRepository;
    private final TlumaczRepository tlumaczRepository;      // *

    public KsiegService(KsiazkaRepository ksiazkaRepository, WydanieRepository wydanieRepository, AutorRepository
            autorRepository, TlumaczRepository tlumaczRepository) {
        this.ksiazkaRepository = ksiazkaRepository;
        this.wydanieRepository = wydanieRepository;
        this.autorRepository = autorRepository;
        this.tlumaczRepository = tlumaczRepository;
    }       // Wstrzyknięcie repozytoriów w serwisie =/= wstrzyknięcie serwisu w kontrolerze

    //      < - - Ksiazki - - >

    public Ksiazka getKsiazkaById(Integer id) {
        Optional<Ksiazka> byId = ksiazkaRepository.findById(id);        // **
        return byId.orElse(null);       // ***
//        return byId.orElseThrow(RuntimeException::new);
//        return byId.orElseThrow(() -> new RuntimeException("Obsługiwany błąd"));
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazkaRepository.findAll();
    }

    public Ksiazka addKsiazka() {
        List<Tlumacz> tlumacz = List.of(new Tlumacz(null, "Jolanta", "Kozak", null));
        List<Wydanie> wydanie = List.of(new Wydanie(null, 2022, 2, "978-83-08-07475-6", Oprawa.TWARDA,
                44.9, "Wydawnictwo Literackie", true, tlumacz));
        List<Autor> autor = List.of(new Autor(null, "Philip", "Roth", 1933, 2018,
                null));
        Ksiazka ksiazka = new Ksiazka(null, "Konające zwierzę", "The Dying Animal", wydanie,
                autor);
        return ksiazkaRepository.save(ksiazka);
    }

    public Ksiazka addKsiazkaDoWydan() {
        Ksiazka ksiazka = new Ksiazka(null, "Opowieści galicyjskie", null, getTwoTopWydania(),
                List.of(getAutorByNazwisko("Stasiuk")));
        return ksiazkaRepository.save(ksiazka);
    }

    public int updateKsiazka() {
        return ksiazkaRepository.updateKsiazka("Jądro ciemności", 6);
    }

    public List<Ksiazka> getAllByIdIsGreaterThan() {
        return ksiazkaRepository.findAllByIdIsGreaterThan(5);
    }

    public List<Ksiazka> getAllByIdIsGreaterThanAndTytulIsContaining() {
        return ksiazkaRepository.findAllByIdIsGreaterThanAndTytulIsContaining(5, "Kr");
    }

    public boolean ksiazkaExistsById(Integer id) {
        return ksiazkaRepository.existsById(id);
    }

    public void ksiazkaDeleteById(Integer id) {
        ksiazkaRepository.deleteById(id);
    }

    //      < - - Autorzy - - >

    public Autor getAutorById(Integer id) {
        Optional<Autor> byId = autorRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Obsługiwany błąd"));
    }

    public Autor getAutorByNazwisko(String nazwisko) {
        Optional<Autor> byNazwisko = autorRepository.findByNazwisko(nazwisko);
        return byNazwisko.orElseThrow(() -> new RuntimeException("Obsługiwany błąd"));
    }

    public Autor addAutorParametry(String imie, String nazwisko, Integer dataUr, Integer dataSm) {
        Autor autor = new Autor(null, imie, nazwisko, dataUr, dataSm, null);
        return autorRepository.save(autor);
    }

    public List<Autor> getAutorzy() {
        return autorRepository.findAll();
    }

    //      < - - Wydania - - >

    public Wydanie getWydanieById(Integer id) {
        Optional<Wydanie> byId = wydanieRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Obsługiwany błąd"));
    }

    public List<Wydanie> addWydania() {
        Wydanie wyd1 = new Wydanie(null, 2016, 4, "978-83-804-9367-4", Oprawa.TWARDA, 34.90,
                "Czarne", true, null);
        Wydanie wyd2 = new Wydanie(null, 2011, 7, "978-83-7536-265-7", Oprawa.MIEKKA, 29.50,
                "Czarne", false, null);
        List<Wydanie> wydania = List.of(wyd1, wyd2);
        return wydanieRepository.saveAll(wydania);
    }

    public List<Wydanie> getTwoTopWydania() {
        return wydanieRepository.findTopElements(PageRequest.of(0, 2));
    }

    public List<Wydanie> getWydania() {
        return wydanieRepository.findAll();
    }

    //      < - - Tlumacze - - >

    public Tlumacz getTlumaczById(Integer id) {
        Optional<Tlumacz> byId = tlumaczRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Obsługiwany błąd"));
    }

    public List<Tlumacz> getTlumacze() {
        return tlumaczRepository.findAll();
    }

    //      < - - Metody do testów - - >

    public void dopiszTytulOryg(Ksiazka ksiazka) {
        if (ksiazka.getTytulOryg() == null) {
            ksiazka.setTytulOryg("Brak / nie dotyczy");
        }
    }

    public void tytulDuzaLitera(Ksiazka ksiazka) {
        if (!Character.isUpperCase(ksiazka.getTytul().charAt(0))) {
            ksiazka.setTytul(ksiazka.getTytul().substring(0, 1).toUpperCase() + ksiazka.getTytul().substring(1));
        }
    }

    public void usmiercAutora(Autor autor) {
        if (autor.getDataSm() == null) {
            autor.setDataSm(2022);
        }
    }

    public void dodajWydanie(Ksiazka ksiazka, Wydanie wydanie) {
        if (ksiazka.getWydania().size() == 0) {
            List<Wydanie> wydania = List.of(wydanie);
            ksiazka.setWydania(wydania);
        }
    }

    public void zmienDostepnosc(Wydanie wydanie) {
        wydanie.setCzyDostepne(!wydanie.getCzyDostepne());
    }

    public void zmienOprawe(Wydanie wydanie) {
        if (wydanie.getOprawa() == Oprawa.MIEKKA) {
            wydanie.setOprawa(Oprawa.TWARDA);
        } else {
            wydanie.setOprawa(Oprawa.MIEKKA);
        }
    }

    public void usunTlumaczy(Wydanie wydanie) {
        if (wydanie.getTlumacze().size() > 0) {
            wydanie.setTlumacze(null);
        }
    }

    public void obnizCene(Wydanie wydanie) {
        if (wydanie.getCena() > 25) {
            wydanie.setCena(wydanie.getCena() - 5);
        }
    }

}
