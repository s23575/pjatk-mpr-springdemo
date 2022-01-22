package pl.edu.pjatk.mpr.springdemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pjatk.mpr.springdemo.Models.Ksiazka;

import javax.transaction.Transactional;
import java.util.List;

// Repozytorium – pozwala na zarządzanie danymi (bazą danych); interfejs rozszerzający interfejs Springowy: CRUD /
//                JPA Repository (to zastąpiło JDBC); CRUD - create, read, update, delete – pozwala na modyfikacje
//                danych; interfejs pomiędzy aplikacją a bazą danych.

// * „KsiazkaRepository”, bo to interfejs obsługujący książki (obiekty typu „Ksiazka”); pierwszy typ generyczny
//   (Ksiazka), drugi – typ ID obiektu.

// ** Dopisanie metody do aktualizacji danych – nie ma takiej „domyślnej” w „JpaRepository”; „int” na początku, aby
//    metoda zwracała liczbę zmienionych wierszy.

// *** Takie formułowanie metod przy pomocy Springa / JpaRepository wykorzstuje się do trzech argumentów – powyżej te
//     liczby zapytanie robi się nieczytelne (=/= zapytanie SQL-owe).

public interface KsiazkaRepository extends JpaRepository<Ksiazka, Integer> {        // *

    @Transactional
    @Modifying      // Ta i powyższa adnotacja są konieczne w przypadku metod modyfikujących
    @Query("UPDATE Ksiazka k SET k.tytul = :tytul where k.id = :id")
    int updateKsiazka(String tytul, Integer id);        // **

    List<Ksiazka> findAllByIdIsGreaterThan(Integer id);     // ***

    List<Ksiazka> findAllByIdIsGreaterThanAndTytulIsContaining(Integer id, String tytul);

}
