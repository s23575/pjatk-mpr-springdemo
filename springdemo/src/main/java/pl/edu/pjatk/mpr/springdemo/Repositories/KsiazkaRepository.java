package pl.edu.pjatk.mpr.springdemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pjatk.mpr.springdemo.Models.Ksiazka;

import javax.transaction.Transactional;
import java.util.List;

// * „KsiazkaRepository”, bo to interfejs obsługujący książki (obiekty typu „Ksiazka”); pierwszy typ generyczny
//   (Ksiazka), drugi – typ ID obiektu.

// ** Dopisanie metody do aktualizacji danych – nie ma takiej „domyślnej” w „JpaRepository”; „int” na początku, aby
//    metoda zwracała liczbę zmienionych wierszy.

// *** Takie formułowanie metod przy pomocy Springa / JpaRepository wykorzstuje się do trzech argumentów – powyżej te
//     liczby zapytanie robi się nieczytelne (=/= zapytanie SQL-owe).

public interface KsiazkaRepository extends JpaRepository<Ksiazka, Integer> {        // *

    @Transactional
    @Modifying
    @Query("UPDATE Ksiazka k SET k.tytul = :tytul where k.id = :id")
    int updateKsiazka(String tytul, Integer id);        // **

    List<Ksiazka> findAllByIdIsGreaterThan(Integer id);     // ***

    List<Ksiazka> findAllByIdIsGreaterThanAndTytulIsContaining(Integer id, String tytul);

}
