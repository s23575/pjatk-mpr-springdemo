package pl.edu.pjatk.mpr.springdemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.mpr.springdemo.Models.Wydanie;

public interface WydanieRepository extends JpaRepository<Wydanie, Integer> {
}
