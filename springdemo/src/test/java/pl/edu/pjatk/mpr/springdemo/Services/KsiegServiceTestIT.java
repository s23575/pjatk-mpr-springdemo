package pl.edu.pjatk.mpr.springdemo.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;     // *

import pl.edu.pjatk.mpr.springdemo.Models.*;
import pl.edu.pjatk.mpr.springdemo.Repositories.AutorRepository;
import pl.edu.pjatk.mpr.springdemo.Repositories.KsiazkaRepository;
import pl.edu.pjatk.mpr.springdemo.Repositories.TlumaczRepository;
import pl.edu.pjatk.mpr.springdemo.Repositories.WydanieRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// * Wskazany pakiet nie jest z pakietu Mockito, ale ze Springa; stąd też nie ma „@ExtendWith(MockitoExtension.class)”.

@SpringBootTest
class KsiegServiceTestIT {

    //      < - - Inicjalizacja testowanego serwisu - - >

    @Autowired
    private KsiegService ksiegService;

    @MockBean
    private KsiazkaRepository ksiazkaRepository;
    @MockBean
    private WydanieRepository wydanieRepository;
    @MockBean
    private AutorRepository autorRepository;
    @MockBean
    private TlumaczRepository tlumaczRepository;

    //      < - - Testy integracyjne - - >

    @Test       // Metody wywołujące testy - sprawdzającą asercję
    void shouldDopiszTytulOryg1() {
        // GIVEN **
        Ksiazka ksiazka = new Ksiazka(null, "Czarne Oceany", null, List.of(), List.of());
        // WHEN
        ksiegService.dopiszTytulOryg(ksiazka);
        // THEN
        assertThat(ksiazka.getTytulOryg()).isEqualTo("Brak / nie dotyczy");
//      Assertions.assertThat(ksiazka.getTytulOryg()).isEqualTo("Brak / nie dotyczy"); //       Stare rozwiązanie

    }

    @Test
    void shouldDopiszTytulOryg2() {
        // GIVEN
        Ksiazka ksiazka = new Ksiazka(null, "Kompleks Portnoya", "Portnoy's Complaint", null,
                null);
        // WHEN
        ksiegService.dopiszTytulOryg(ksiazka);
        // THEN
        assertThat(ksiazka.getTytulOryg()).isNotEqualTo("Brak / nie dotyczy");
    }

    @Test
    void shouldTytulDuzaLitera() {
        // GIVEN
        Ksiazka ksiazka = new Ksiazka(null, "extensa", null, null, null);
        // WHEN
        ksiegService.tytulDuzaLitera(ksiazka);
        // THEN
        assertThat(Character.isUpperCase(ksiazka.getTytul().charAt(0))).isTrue();
    }

    @Test
    void shouldUsmiercAutora1() {
        // GIVEN
        Autor autor = new Autor(null, "Iraj", "Pezeshkzad", 1928, null, null);
        // WHEN
        ksiegService.usmiercAutora(autor);
        // THEN
        assertThat(autor.getDataSm()).isEqualTo(2022);
    }

    @Test
    void shouldUsmiercAutora2() {
        // GIVEN
        Autor autor = new Autor(null, "Philip", "Roth", 1933, 2018, null);
        // WHEN
        ksiegService.usmiercAutora(autor);
        // THEN
        assertThat(autor.getDataSm()).isNotEqualTo(2022);
    }

    @Test
    void shouldDodajWydanie() {
        // GIVEN
        Ksiazka ksiazka = new Ksiazka(null, "Księgi Jakubowe", null, List.of(), null);
        Wydanie wydanie = new Wydanie(null, 2021, 2, "978-83-08-07328-5", Oprawa.TWARDA, 74.90,
                "Wydawnictwo Literackie", true, null);
        // WHEN
        ksiegService.dodajWydanie(ksiazka, wydanie);
        // THEN
        assertThat(ksiazka.getWydania().size()).isGreaterThan(0);
    }

    @Test
    void shouldZmienDostepnosc1() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2021, 2, "978-83-08-07328-5", Oprawa.TWARDA, 74.90,
                "Wydawnictwo Literackie", true, null);
        // WHEN
        ksiegService.zmienDostepnosc(wydanie);
        // THEN
        assertThat(wydanie.getCzyDostepne()).isFalse();
    }

    @Test
    void shouldZmienDostepnosc2() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2015, 1, "978-83-08-04939-6", Oprawa.TWARDA, 69.9,
                "Wydawnictwo Literackie", false, null);
        // WHEN
        ksiegService.zmienDostepnosc(wydanie);
        // THEN
        assertThat(wydanie.getCzyDostepne()).isTrue();
    }

    @Test
    void shouldZmienOprawe1() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2015, 1, "978-83-08-04939-6", Oprawa.TWARDA, 69.9,
                "Wydawnictwo Literackie", false, null);
        // WHEN
        ksiegService.zmienOprawe(wydanie);
        // THEN
        assertThat(wydanie.getOprawa()).isEqualTo(Oprawa.MIEKKA);
    }

    @Test
    void shouldZmienOprawe2() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2017, null, "978-83-08-06115-2", Oprawa.MIEKKA, 8.99,
                "Wydawnictwo Literackie", false, null);
        // WHEN
        ksiegService.zmienOprawe(wydanie);
        // THEN
        assertThat(wydanie.getOprawa()).isEqualTo(Oprawa.TWARDA);
    }

    @Test
    void shouldUsunTlumaczy() {
        // GIVEN
        List<Tlumacz> tlumacz = List.of(new Tlumacz(null, "Jan Krzysztof", "Kelus", null));
        Wydanie wydanie = new Wydanie(null, 2014, 4, "978-83-7392-747-6", Oprawa.MIEKKA, 35.0,
                "Wydawnictwo Literackie", true, tlumacz);
        // WHEN
        ksiegService.usunTlumaczy(wydanie);
        // THEN
        assertThat(wydanie.getTlumacze()).isNull();
    }

    @Test
    void shouldObnizCene1() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2014, 4, "978-83-7392-747-6", Oprawa.MIEKKA, 35.0,
                "Wydawnictwo Literackie", true, null);
        // WHEN
        ksiegService.obnizCene(wydanie);
        // THEN
        assertThat(wydanie.getCena() + 5).isGreaterThan(25);
    }

    @Test
    void shouldObnizCene2() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2017, null, "978-83-08-06115-2", Oprawa.MIEKKA, 8.99,
                "Wydawnictwo Literackie", false, null);
        // WHEN
        ksiegService.obnizCene(wydanie);
        // THEN
        assertThat(wydanie.getCena()).isLessThanOrEqualTo(25);
    }

    //      < - - Testy integracyjne z mockowaniem - - >

    @Test
    void shouldGetKsiazkaById() {
        when(ksiazkaRepository.findById(any()))
                .thenReturn(Optional.of(new Ksiazka()));

        Ksiazka byId = ksiegService.getKsiazkaById(1);

        assertThat(byId).isNotNull();
    }

    @Test
    void shouldNotGetKsiazkaById() {
        when(ksiazkaRepository.findById(any()))
                .thenReturn(Optional.empty());

        Ksiazka byId = ksiegService.getKsiazkaById(1);

        assertThat(byId).isNull();
    }

    @Test
    void shouldGetKsiazki() {
        List<Ksiazka> ksiazki = List.of(new Ksiazka(), new Ksiazka(), new Ksiazka());

        when(ksiazkaRepository.findAll())
                .thenReturn(ksiazki);

        List<Ksiazka> wszystkieKsiazki = ksiegService.getKsiazki();

        assertThat(wszystkieKsiazki).hasSize(ksiazki.size());
//        assertThat(wszystkieKsiazki).isNotEmpty();
    }

    @Test
    void shouldNotGetKsiazki() {
        when(ksiazkaRepository.findAll())
                .thenReturn(List.of());

        List<Ksiazka> wszystkieKsiazki = ksiegService.getKsiazki();

        assertThat(wszystkieKsiazki).isEmpty();
    }

    @Test
    void shouldGetAutorByNazwisko() {
        when(autorRepository.findByNazwisko(any()))
                .thenReturn(Optional.of(new Autor()));

        Optional<Autor> byNazwisko = autorRepository.findByNazwisko("Stasiuk");

        assertThat(byNazwisko).isNotNull();
    }

    @Test
    void shouldNotGetAutorByNazwisko() {
        when(autorRepository.findByNazwisko(any()))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> { ksiegService.getAutorByNazwisko("Pezeshkzad"); }
        );

        assertEquals("Obsługiwany błąd", exception.getMessage());
    }

    @Test
    void shouldGetWydania() {
        List<Wydanie> wydania = List.of(new Wydanie(), new Wydanie(), new Wydanie());

        when(wydanieRepository.findAll())
                .thenReturn(wydania);

        List<Wydanie> wszystkieWydania = ksiegService.getWydania();

        assertThat(wszystkieWydania).isNotEmpty();
    }

    @Test
    void shouldNotGetWydania() {
        when(wydanieRepository.findAll())
                .thenReturn(List.of());

        List<Wydanie> wszystkieWydania = ksiegService.getWydania();

        assertThat(wszystkieWydania).isEmpty();
    }

    @Test
    void shouldKsiazkaExistsById() {
        when(ksiazkaRepository.existsById(any()))
                .thenReturn(true);

        boolean ksiazkaExistsById = ksiegService.ksiazkaExistsById(1);

        assertThat(ksiazkaExistsById).isTrue();
    }

    @Test
    void shouldNotKsiazkaExistsById() {
        when(ksiazkaRepository.existsById(any()))
                .thenReturn(false);

        boolean ksiazkaExistsById = ksiegService.ksiazkaExistsById(1);

        assertThat(ksiazkaExistsById).isFalse();
    }

    @Test
    void shouldDeleteKsiazkaById() {
//        doNothing().when(ksiazkaRepository).deleteById(any());

        ksiegService.ksiazkaDeleteById(1);

        verify(ksiazkaRepository/*, times(2)*/).deleteById(any());

    }

    @Test
    void shouldGetTlumacze() {
        List<Tlumacz> tlumacze = List.of(new Tlumacz(), new Tlumacz(), new Tlumacz());

        when(tlumaczRepository.findAll())
                .thenReturn(tlumacze);

        List<Tlumacz> wszyscyTlumacze = ksiegService.getTlumacze();

        assertThat(wszyscyTlumacze).isNotEmpty();
    }

}
