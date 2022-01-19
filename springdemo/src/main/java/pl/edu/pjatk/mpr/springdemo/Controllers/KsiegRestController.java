package pl.edu.pjatk.mpr.springdemo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.edu.pjatk.mpr.springdemo.Models.Autor;
import pl.edu.pjatk.mpr.springdemo.Models.Ksiazka;
import pl.edu.pjatk.mpr.springdemo.Models.Tlumacz;
import pl.edu.pjatk.mpr.springdemo.Models.Wydanie;
import pl.edu.pjatk.mpr.springdemo.Services.KsiegService;

import java.util.List;

// * Spring zapewnia obsługę odpowiednio zonaczonych klas – gwarantuje dodatkowe zachowania

// ** Bez „final” i bez konstruktora wystąpi błąd („NullPointerException” i status 500); przy final, ale bez
//    konstruktora, aplikacja nie zbuduje się, bo obiekt nie zostanie zainicjalizowany: „java: variable ksiegService not
//    initialized in the default constructor”; to jest przykład zależności: RestController nie może istnieć bez serwisu

@RestController     // „Kubeł” obsługujący zapytania *
@RequestMapping("/ksieg")       // Adres, na który będą wysyłane zapytania

public class KsiegRestController {

//    @Autowired
//    KsiegService ksiegService;        // Wstrzyknięcie zależności - ale to nie jest najlepsze rozwiązanie

    private final KsiegService ksiegService;        // Wstrzyknięcie zależności *

    public KsiegRestController(KsiegService ksiegService) {
        this.ksiegService = ksiegService;
    }

    //      < - - Książki - - >

    @GetMapping("/ksiazka/{id}")
    public ResponseEntity<Ksiazka> getKsiazkaById(@PathVariable Integer id) {
        return ResponseEntity.ok(ksiegService.getKsiazkaById(id));
    }

    @GetMapping("/ksiazki")
    public ResponseEntity<List<Ksiazka>> getKsiazki() {
        return ResponseEntity.ok(ksiegService.getKsiazki());
    }

    @GetMapping("/ksiazka/dodaj")
    public ResponseEntity<Ksiazka> addKsiazka() {
        return ResponseEntity.ok(ksiegService.addKsiazka());
    }

    @GetMapping("/ksiazka/dodajdowydan")
    public ResponseEntity<Ksiazka> addKsiazkaDoWydan() {
        return ResponseEntity.ok(ksiegService.addKsiazkaDoWydan());
    }

    @GetMapping("/ksiazka/zmien")
    public int updateKsiazka() {
        return ksiegService.updateKsiazka();
    }

    @GetMapping("/ksiazki/greater")
    public ResponseEntity<List<Ksiazka>> getAllByIdIsGreaterThan() {
        return ResponseEntity.ok(ksiegService.getAllByIdIsGreaterThan());
    }

    @GetMapping("/ksiazki/greatername")
    public ResponseEntity<List<Ksiazka>> getAllByIdIsGreaterThanAndTytulIsContaining() {
        return ResponseEntity.ok(ksiegService.getAllByIdIsGreaterThanAndTytulIsContaining());
    }

    @GetMapping("/ksiazka/istnieje/{id}")
    public boolean ksiazkaExistsById(@PathVariable Integer id) {
        return ksiegService.ksiazkaExistsById(id);
    }

    @GetMapping("/ksiazka/usun/{id}")
    public void deleteKsiazkaById(@PathVariable Integer id) {
        ksiegService.ksiazkaDeleteById(id);
    }

    //      < - - Autorzy - - >

    @GetMapping("/autor/id/{id}")
    public ResponseEntity<Autor> getAutorByNazwisko(@PathVariable Integer id) {
        return ResponseEntity.ok(ksiegService.getAutorById(id));
    }

    @GetMapping("/autor/nazwisko/{nazwisko}")        // Wyszukiwanie jest „case sensitive”
    public ResponseEntity<Autor> getAutorByNazwisko(@PathVariable String nazwisko) {
        return ResponseEntity.ok(ksiegService.getAutorByNazwisko(nazwisko));
    }

    @GetMapping("/autor/dodaj")
    public ResponseEntity<Autor> addAutorParametry(@RequestParam String imie, String nazwisko, Integer dataUr, Integer
            dataSm) {
        return ResponseEntity.ok(ksiegService.addAutorParametry(imie, nazwisko, dataUr, dataSm));
    }       // http://localhost:8080/ksieg/autor/dodaj?imie=Charles&nazwisko=Bukowski&dataUr=1920&dataSm=1994

    @GetMapping("/autorzy")
    public ResponseEntity<List<Autor>> getAutorzy() {
        return ResponseEntity.ok(ksiegService.getAutorzy());
    }

    //      < - - Wydania - - >

    @GetMapping("/wydanie/{id}")
    public ResponseEntity<Wydanie> getWydanieById(@PathVariable Integer id) {
        return ResponseEntity.ok(ksiegService.getWydanieById(id));
    }

    @GetMapping("/wydania/dodaj")
    public ResponseEntity<List<Wydanie>> addWydania() {
        return ResponseEntity.ok(ksiegService.addWydania());
    }

    @GetMapping("/wydania")
    public ResponseEntity<List<Wydanie>> getWydania() {
        return ResponseEntity.ok(ksiegService.getWydania());
    }

    @GetMapping("/wydania/top")
    public ResponseEntity<List<Wydanie>> getTwoTopWydania() {
        return ResponseEntity.ok(ksiegService.getTwoTopWydania());
    }

    //      < - - Tłumacze - - >

    @GetMapping("/tlumacz/{id}")
    public ResponseEntity<Tlumacz> getTlumaczById(@PathVariable Integer id) {
        return ResponseEntity.ok(ksiegService.getTlumaczById(id));
    }

    @GetMapping("/tlumacze")
    public ResponseEntity<List<Tlumacz>> getTlumacze() {
        return ResponseEntity.ok(ksiegService.getTlumacze());
    }
}
