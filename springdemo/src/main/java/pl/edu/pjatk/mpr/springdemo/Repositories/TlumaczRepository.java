package pl.edu.pjatk.mpr.springdemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.mpr.springdemo.Models.Tlumacz;

public interface TlumaczRepository extends JpaRepository<Tlumacz, Integer> {
}
