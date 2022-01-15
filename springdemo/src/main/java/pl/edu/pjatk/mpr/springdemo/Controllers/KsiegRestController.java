package pl.edu.pjatk.mpr.springdemo.Controllers;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.pjatk.mpr.springdemo.Models.Autor;
import pl.edu.pjatk.mpr.springdemo.Models.Ksiazka;
import pl.edu.pjatk.mpr.springdemo.Models.Wydanie;
import pl.edu.pjatk.mpr.springdemo.Services.KsiegService;

@RestController
@RequestMapping("/ksieg")

public class KsiegRestController {

//    @Autowired
//    KsiegService ksiegService;
      // To też zadziała, ale to nie jest najlepsze rozwiązanie

    private final KsiegService ksiegService;
    // Bez final i bez konstruktora poniżej to będzie zwracać error (NullPointerException i status 500);
    // Przy final, ale bez konstruktora, aplikacja w ogóle się nie zbuduje - bo obiekt nie został zainicjalizowany:
    // "java: variable ksiegService not initialized in the default constructor"
    // To też pokazuje przykład zależności - RestController nie może istnieć bez serwisu

    public KsiegRestController(KsiegService ksiegService) {
        this.ksiegService = ksiegService;
    }

    @GetMapping("/przykksiazk")
    public ResponseEntity<Ksiazka> getPrzykKsiazk() {
        return ResponseEntity.ok(ksiegService.getPrzykKsiazk());
    }

    @GetMapping("/przykaut")
    public ResponseEntity<Autor> getPrzykAut() {
        return ResponseEntity.ok(ksiegService.getPrzykAutor());
    }

    @GetMapping("/przykwyd")
    public ResponseEntity<Wydanie> getPrzykWyd() {
        return ResponseEntity.ok(ksiegService.getPrzykWyd());
    }

    @GetMapping("/przykautoiminazw")
    public ResponseEntity<Autor> getPrzykAutoArgum() {
        return ResponseEntity.ok(ksiegService.getPrzykAutorArugm("Jacek","Dukaj", 1974));
    }

}
