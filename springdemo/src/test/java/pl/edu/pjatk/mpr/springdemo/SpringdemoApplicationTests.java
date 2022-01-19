package pl.edu.pjatk.mpr.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// * Domyślny test (integracyjny) w aplikacji springowej – sprawdza, czy aplikacja się uruchamia (start i stop,
//   natychmiast); najważniejsza część testu integracyjnego to załadowanie kontekstu – to decyduje, że coś jest
//   testem integracyjnym.

@SpringBootTest
class SpringdemoApplicationTests {		// *

	@Test
	void contextLoads() {
	}

}
