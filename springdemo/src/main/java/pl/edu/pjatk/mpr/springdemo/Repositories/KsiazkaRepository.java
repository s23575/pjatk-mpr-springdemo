package pl.edu.pjatk.mpr.springdemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pjatk.mpr.springdemo.Models.Ksiazka;

import javax.transaction.Transactional;
import java.util.List;

public interface KsiazkaRepository extends JpaRepository<Ksiazka, Integer> {
    // KsiazkaRepository, bo ten interfejs obsługuje obiekty Ksiazka - pierwszy typ generyczny, drugi - ID obiektu

    @Transactional
    @Modifying
    @Query("UPDATE Ksiazka k SET k.tytul = :tytul where k.id = :id")
    int updateKsiazka(String tytul, Integer id);
    // Dopisanie własnej metody do aktualizacji danych - bo nie ma takiej "domyślnej"
    // Int na początku dlatego, żeby zwracał liczbę poprawionych wierszy

    List<Ksiazka> findAllByIdIsGreaterThan(Integer id);

    // To się raczej wykorzystuje do trzech argumentów, powyżej robi się nieczytelne
    List<Ksiazka> findAllByIdIsGreaterThanAndTytulIsContaining(Integer id, String tytul);

}
