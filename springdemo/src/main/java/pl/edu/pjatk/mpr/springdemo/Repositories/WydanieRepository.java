package pl.edu.pjatk.mpr.springdemo.Repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pjatk.mpr.springdemo.Models.Wydanie;

import javax.transaction.Transactional;
import java.util.List;

// * „WydanieRepository”, bo to interfejs obsługujący wydania (obiekty typu „Wydanie”); pierwszy typ generyczny
//   (Wydanie), drugi – typ ID obiektu.

public interface WydanieRepository extends JpaRepository<Wydanie, Integer> {        // *

    @Transactional
    @Query(value = "SELECT w FROM Wydanie w ORDER BY w.id DESC")
    List<Wydanie> findTopElements(Pageable pageable);

}
