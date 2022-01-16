package pl.edu.pjatk.mpr.springdemo.Services;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.mpr.springdemo.Models.*;
import pl.edu.pjatk.mpr.springdemo.Repositories.AutorRepository;
import pl.edu.pjatk.mpr.springdemo.Repositories.KsiazkaRepository;
import pl.edu.pjatk.mpr.springdemo.Repositories.WydanieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KsiegService {

    private final KsiazkaRepository ksiazkaRepository;
    private final WydanieRepository wydanieRepository;
    private final AutorRepository autorRepository;
    // Wstrzynięcie można zrobić przez "Autowired", analogicznie, jak w przypadku serwisów i kontrolera

    public KsiegService(KsiazkaRepository ksiazkaRepository, WydanieRepository wydanieRepository, AutorRepository
            autorRepository) {
        this.ksiazkaRepository = ksiazkaRepository;
        this.wydanieRepository = wydanieRepository;
        this.autorRepository = autorRepository;
    }
    // Wstrzyknięcie w serwisie, żeby to rozgraniczyć - nie w kontrolerze; z tego można teraz korzystać w metodach

    //<-- Ksiazki -->

    public Ksiazka getPrzykKsiazk() {
        Wydanie wyd1 = new Wydanie(null, 2015, 1, "978-83-777-9221-6", Oprawa.TWARDA, 49.9,
                "Znak", true, null);
        Wydanie wyd2 = new Wydanie(null, 2019, null, "978-83-280-6779-0", Oprawa.MIEKKA, 24.99,
                "Wilga", true, null);
        List<Wydanie> wydanie = List.of(wyd1, wyd2);
//        List<Wydanie> wydanie = getWszystkWyd();
//        List<Wydanie> wydanie = getWszystkPrzykWyd();
        List<Autor> autor = List.of(new Autor(null, "Fiodor", "Dostojewski", 1821, 1881,
                null));
        Ksiazka ksiazka = new Ksiazka(null, "Zbrodnia i kara", "Priestuplenije i nakazanije", wydanie,
                autor);
        return ksiazkaRepository.save(ksiazka);
    }

    public List<Ksiazka> getWszystkKsiazk() {
        return ksiazkaRepository.findAll();
    }

    public int updateKsiazka() {
        return ksiazkaRepository.updateKsiazka("Nowy przykladowy tytul", 15);
    }

    public List<Ksiazka> getAllByIdIsGreaterThan() {
        return ksiazkaRepository.findAllByIdIsGreaterThan(5);
    }

    public List<Ksiazka> getAllByIdIsGreaterThanAndTytulIsContaining() {
        return ksiazkaRepository.findAllByIdIsGreaterThanAndTytulIsContaining(5, "Kr");
    }

    public Ksiazka getKsiazkaById(Integer id) {
        Optional<Ksiazka> byId = ksiazkaRepository.findById(id);
        // findById domyślnie zwraca typ Optional<T>; to widać w KsiazkaRepository -> JpaRepository ->
        // PagingAndSortingRepository -> CrudRepository

//        return byId.orElseThrow(RuntimeException::new);
//        return byId.orElseThrow(() -> new RuntimeException("Obsługiwany błąd"));
        return byId.orElse(null);
        // Po "byId." jest wiele różnych opcji, co można zrobić w sytuacji, gdy szukana wartość nie zostanie znaleziona
        // - gdy zwrócony obiekt będzie inny ("zwróć mi obiekt taki, a jak go nie ma, to...")
        // RuntimeException zwraca error 500: Internal Server Error
    }

    public boolean existsKsiazkaById(Integer id) {
        return ksiazkaRepository.existsById(id);
    }

    public void deleteKsiazkaById(Integer id) {
        ksiazkaRepository.deleteById(id);
    }


    //<-- Autorzy -->

    public Autor getPrzykAutor() {
        return new Autor(1, "Fiodor", "Dostojewski", 1821, 1881, null);
    }

    public Autor getPrzykAutorArugm(String imie, String nazwisko, Integer dataur) {
        return new Autor(1, imie, nazwisko, dataur, null, null);
    }

    public Autor getPrzykAutorParam(String imie, String nazwisko, Integer dataur, Integer datasm) {
        Autor autor = new Autor(null, imie, nazwisko, dataur, datasm, null);
        return autorRepository.save(autor);
    }

    public Autor getAutorByNazwisko(String nazwisko) {
        Optional<Autor> byNazwisko = autorRepository.findByNazwisko(nazwisko);
//        return byNazwisko.orElseThrow(RuntimeException::new);
        return byNazwisko.orElseThrow(() -> new RuntimeException("Obsługiwany błąd"));
//        return byNazwisko.orElse(new Autor(null,null,nazwisko,null,null,null));
    }

    //<-- Wydania -->

    public Wydanie getPrzykWyd() {
        Wydanie wydanie = new Wydanie(null, 2015, 1, "978-83-777-9221-6", Oprawa.TWARDA, 49.9,
                "Znak", true, null);
        return wydanieRepository.save(wydanie);
    }

    public List<Wydanie> getWszystkPrzykWyd() {
        Wydanie wyd1 = new Wydanie(null, 2015, 1, "978-83-777-9221-6", Oprawa.TWARDA, 49.9,
                "Znak", true, null);
        Wydanie wyd2 = new Wydanie(null, 2019, null, "978-83-280-6779-0", Oprawa.MIEKKA, 24.99,
                "Wilga", true, null);
        List<Wydanie> wydania = List.of(wyd1, wyd2);
        return wydanieRepository.saveAll(wydania);
    }

    public List<Wydanie> getWszystkWyd() {
        return wydanieRepository.findAll();
    }

    // <-- Metody do testów -->

    public void dopiszTytuloryg(Ksiazka ksiazka) {
        if (ksiazka.getTytuloryg() == null) {
            ksiazka.setTytuloryg("Brak / nie dotyczy");
        }
    }

    public void tytulDuzaLitera(Ksiazka ksiazka) {
        if (!Character.isUpperCase(ksiazka.getTytul().charAt(0))) {
            ksiazka.setTytul(ksiazka.getTytul().substring(0, 1).toUpperCase() + ksiazka.getTytul().substring(1));
        }
    }

    public void usmiercAutora(Autor autor) {
        if (autor.getDatasm() == null) {
            autor.setDatasm(2022);
        }
    }

    public void dodajWydanie(Ksiazka ksiazka, Wydanie wydanie) {
        if (ksiazka.getWydanie().size() == 0) {
            List<Wydanie> wydania = List.of(wydanie);
            ksiazka.setWydanie(wydania);
        }
    }

    public void zmienDostepnosc(Wydanie wydanie) {
//        if (wydanie.getCzydostepne()) {
//            wydanie.setCzydostepne(false);
//        } else {
//            wydanie.setCzydostepne(true);
//        }
        wydanie.setCzydostepne(!wydanie.getCzydostepne());
    }

    public void zmienOprawe(Wydanie wydanie) {
        if (wydanie.getOprawa() == Oprawa.MIEKKA) {
            wydanie.setOprawa(Oprawa.TWARDA);
        } else {
            wydanie.setOprawa(Oprawa.MIEKKA);
        }
    }

    public void usunTlumaczy(Wydanie wydanie) {
        if (wydanie.getTlumacz().size() > 0) {
            wydanie.setTlumacz(null);
        }
    }

    public void obnizCene(Wydanie wydanie) {
        if (wydanie.getCena() > 25) {
            wydanie.setCena(wydanie.getCena() - 5);
        }
    }

}
