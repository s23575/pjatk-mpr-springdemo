package pl.edu.pjatk.mpr.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Domyślny test (integracyjny) w aplikacji springowej - sprawdza, czy aplikacja się uruchamia (start i stop,
// natychmiast)

// Najważniejsza część testu integracyjnego - ładuje kontekst; to decyduje o tym, że coś jest testem integracyjnym
@SpringBootTest
class SpringdemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
