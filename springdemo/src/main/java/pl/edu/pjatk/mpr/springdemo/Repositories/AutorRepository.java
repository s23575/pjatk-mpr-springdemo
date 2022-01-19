package pl.edu.pjatk.mpr.springdemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.mpr.springdemo.Models.Autor;

import java.util.Optional;

// * „AutorRepository”, bo to interfejs obsługujący autorów (obiekty typu „Autor”); pierwszy typ generyczny
//   (Autor), drugi – typ ID obiektu.

public interface AutorRepository extends JpaRepository<Autor, Integer> {        // *

    Optional<Autor> findByNazwisko(String nazwisko);

}
