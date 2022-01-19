package pl.edu.pjatk.mpr.springdemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.mpr.springdemo.Models.Tlumacz;

// * „TlumaczRepository”, bo to interfejs obsługujący tlumaczy (obiekty typu „Tlumacz”); pierwszy typ generyczny
//   (Tlumacz), drugi – typ ID obiektu.

public interface TlumaczRepository extends JpaRepository<Tlumacz, Integer> {        // *
}
