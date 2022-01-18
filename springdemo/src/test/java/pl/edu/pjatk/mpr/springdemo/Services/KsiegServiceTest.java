package pl.edu.pjatk.mpr.springdemo.Services;

// import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class KsiegServiceTest {

    // <-- Inicjalizacja testowanego serwisu -->

    @Mock
    private KsiazkaRepository ksiazkaRepository;
    @Mock
    private WydanieRepository wydanieRepository;
    @Mock
    private AutorRepository autorRepository;
    @Mock
    private TlumaczRepository tlumaczRepository;

    @InjectMocks
    private KsiegService ksiegService; //= new KsiegService(null, null, null);
    // Repozytoria to interfejsy - nie mogą być "new", zawsze musi być ich implementacja; nie można ich użyć
    // Czasami tworzy się "sztuczne" repozytoria, na potrzeby testów; poniżej nie będą wywoływane metody z
    // repozytoriów, więc tutaj "null" zadziała

    // <-- Testy -->

    // <-- Testy jednostkowe -->

    // Metoda wywołuje test - sprawdzającą asercję
    @Test
    void shouldDopiszTytuloryg1() {
        // GIVEN
        Ksiazka ksiazka = new Ksiazka(null, "Imperium chmur", null, List.of(), List.of());
        // WHEN
        ksiegService.dopiszTytuloryg(ksiazka);
        // THEN
        // Assertions.assertThat() - ale to stare rozwiązanie, bardziej wskazane jest poniższe:
        assertThat(ksiazka.getTytuloryg()).isEqualTo("Brak / nie dotyczy");
    }

    @Test
    void shouldDopiszTytuloryg2() {
        // GIVEN
        Ksiazka ksiazka = new Ksiazka(null, "Zbrodnia i kara", "Priestuplenije i nakazanije", List.of(),
                List.of());
        // WHEN
        ksiegService.dopiszTytuloryg(ksiazka);
        // THEN
        assertThat(ksiazka.getTytuloryg()).isNotEqualTo("Brak / nie dotyczy");
    }

    @Test
    void shouldTytulDuzaLitera() {
        // GIVEN
        Ksiazka ksiazka = new Ksiazka(null, "katedra", null, List.of(), List.of());
        // WHEN
        ksiegService.tytulDuzaLitera(ksiazka);
        // THEN
        assertThat(Character.isUpperCase(ksiazka.getTytul().charAt(0))).isTrue();
    }

    @Test
    void shouldUsmiercAutora1() {
        // GIVEN
        Autor autor = new Autor(null, "Jacek", "Dukaj", 1974, null, List.of());
        // WHEN
        ksiegService.usmiercAutora(autor);
        // THEN
        assertThat(autor.getDatasm()).isEqualTo(2022);
    }

    @Test
    void shouldUsmiercAutora2() {
        // GIVEN
        Autor autor = new Autor(null, "Fiodor", "Dostojewski", 1821, 1881, null);
        // WHEN
        ksiegService.usmiercAutora(autor);
        // THEN
        assertThat(autor.getDatasm()).isNotEqualTo(2022);
    }

    @Test
    void shouldDodajWydanie1() {
        // GIVEN
        Ksiazka ksiazka = new Ksiazka(null, "Zbrodnia i kara", "Priestuplenije i nakazanije", List.of(),
                List.of());
        Wydanie wydanie = new Wydanie(null, 2015, 1, "978-83-777-9221-6", Oprawa.TWARDA, 49.9,
                "Znak", true, null);
        // WHEN
        ksiegService.dodajWydanie(ksiazka, wydanie);
        // THEN
        assertThat(ksiazka.getWydanie().size()).isGreaterThan(0);
    }

    @Test
    void shouldZmienDostepnosc1() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2015, 1, "978-83-777-9221-6", Oprawa.TWARDA, 49.9,
                "Znak", true, null);
        // WHEN
        ksiegService.zmienDostepnosc(wydanie);
        // THEN
        assertThat(wydanie.getCzydostepne()).isFalse();
    }

    @Test
    void shouldZmienDostepnosc2() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2015, 1, "978-83-777-9221-6", Oprawa.TWARDA, 49.9,
                "Znak", false, null);
        // WHEN
        ksiegService.zmienDostepnosc(wydanie);
        // THEN
        assertThat(wydanie.getCzydostepne()).isTrue();
    }

    @Test
    void shouldZmienOprawe1() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2015, 1, "978-83-777-9221-6", Oprawa.TWARDA, 49.9,
                "Znak", true, null);
        // WHEN
        ksiegService.zmienOprawe(wydanie);
        // THEN
        assertThat(wydanie.getOprawa()).isEqualTo(Oprawa.MIEKKA);
    }

    @Test
    void shouldZmienOprawe2() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2019, null, "978-83-280-6779-0", Oprawa.MIEKKA, 24.99,
                "Wilga", true, null);
        // WHEN
        ksiegService.zmienOprawe(wydanie);
        // THEN
        assertThat(wydanie.getOprawa()).isEqualTo(Oprawa.TWARDA);
    }

    @Test
    void shouldUsunTlumaczy() {
        // GIVEN
        List<Tlumacz> tlumacz = List.of(new Tlumacz(null, "Czesław", "Jastrzębiec-Kozłowski", List.of()));
        Wydanie wydanie = new Wydanie(null, 2015, 1, "978-83-777-9221-6", Oprawa.TWARDA, 49.9,
                "Znak", true, tlumacz);
        // WHEN
        ksiegService.usunTlumaczy(wydanie);
        // THEN
        assertThat(wydanie.getTlumacz()).isNull();
    }

    @Test
    void shouldObnizCene1() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2015, 1, "978-83-777-9221-6", Oprawa.TWARDA, 49.9,
                "Znak", true, null);
        // WHEN
        ksiegService.obnizCene(wydanie);
        // THEN
        assertThat(wydanie.getCena() + 5).isGreaterThan(25);
    }

    @Test
    void shouldObnizCene2() {
        // GIVEN
        Wydanie wydanie = new Wydanie(null, 2019, null, "978-83-280-6779-0", Oprawa.MIEKKA, 25.0,
                "Wilga", true, null);
        // WHEN
        ksiegService.obnizCene(wydanie);
        // THEN
        assertThat(wydanie.getCena()).isLessThanOrEqualTo(25);
    }

    //<-- Mockowanie -->

    @Test
    void shouldgetKsiazkaById() {
        when(ksiazkaRepository.findById(any()))
                .thenReturn(Optional.of(new Ksiazka()));
        // Bez powyższego fragmentu kodu rezultatem testu jest AssertionError; jest on jest spowodowany tym, że nie
        // ma bazy / nie ma książk od o określonym id; w rezultacie zwracany jest Optional, który jest obsłużony w
        // ten sposób ("orElse"), że zwraca nulla; to wymaga więc zamockowania obiektu - książki, która powinna
        // zostać zwrócona


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
    void shouldGetAutorByNaziwsko() {
        when(autorRepository.findByNazwisko(any()))
                .thenReturn(Optional.of(new Autor()));

        Optional<Autor> byNazwisko = autorRepository.findByNazwisko("Dostojewski");

        assertThat(byNazwisko).isNotNull();
    }

    @Test
    void shouldNotGetAutorByNaziwsko() {
        when(autorRepository.findByNazwisko(any()))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> { ksiegService.getAutorByNazwisko("Dostojewski"); }
        );

        assertEquals("Obsługiwany błąd", exception.getMessage());
    }

    @Test
    void shouldGetWszystkKsiazk() {
        List<Ksiazka> ksiazki = List.of(new Ksiazka(), new Ksiazka(), new Ksiazka());

        when(ksiazkaRepository.findAll())
                .thenReturn(ksiazki);

        List<Ksiazka> wszystkKsiazk = ksiegService.getWszystkKsiazk();

        assertThat(wszystkKsiazk).hasSize(ksiazki.size());
//        assertThat(wszystkKsiazk).isNotEmpty();
    }

    @Test
    void shouldGetZadnaKsiazk() {
        when(ksiazkaRepository.findAll())
                .thenReturn(List.of());

        List<Ksiazka> wszystkKsiazk = ksiegService.getWszystkKsiazk();

        assertThat(wszystkKsiazk).isEmpty();
    }

    @Test
    void shouldGetWszystkWyd() {
        List<Wydanie> wydania = List.of(new Wydanie(), new Wydanie(), new Wydanie());

        when(wydanieRepository.findAll())
                .thenReturn(wydania);

        List<Wydanie> wszystkWyd = ksiegService.getWszystkWyd();

        assertThat(wszystkWyd).isNotEmpty();
    }

    @Test
    void shouldGetZadneWyd() {
        when(wydanieRepository.findAll())
                .thenReturn(List.of());

        List<Wydanie> wszystkWyd = ksiegService.getWszystkWyd();

        assertThat(wszystkWyd).isEmpty();
    }

    @Test
    void shouldExistsKsiazkaById() {
        when(ksiazkaRepository.existsById(any()))
                .thenReturn(true);

        boolean existsKsiazkaById = ksiegService.existsKsiazkaById(1);

        assertThat(existsKsiazkaById).isTrue();
    }

    @Test
    void shouldNotExistsKsiazkaById() {
        when(ksiazkaRepository.existsById(any()))
                .thenReturn(false);

        boolean existsKsiazkaById = ksiegService.existsKsiazkaById(1);

        assertThat(existsKsiazkaById).isFalse();
    }

    @Test
    void shouldDeleteKsiazkaById() {
//        doNothing().when(ksiazkaRepository).deleteById(any());
        // Mock, który nic nie robi; może być stosowany tylko na metodach zwracających void

        ksiegService.deleteKsiazkaById(1);

        verify(ksiazkaRepository/*, times(2)*/).deleteById(any());
        // Verify prosi o Mocka i dokonuje weryfikacji - ale tylko jeden raz; w przypadku odkomentowania times(2)
        // weryfikacja zostanie wykonana dwukrotnie (ale wtedy też ksiazkaRepository.deletebyId() w samym serwisie
        // musiałoby się wykonywać dwukrotnie;

    }
}
