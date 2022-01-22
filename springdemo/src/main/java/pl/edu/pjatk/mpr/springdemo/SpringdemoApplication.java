package pl.edu.pjatk.mpr.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pjatk.mpr.springdemo.Models.Autor;

// Maven, Gradle – narzędzia do budowania aplikacji (Maven – prostszy, „out-of-the-box”, Gradle – daje więcej
// 				   możliwości konfiguracji); odpowiedzialne za zarządzanie zależnościami – „dependencies”.

// Zależności    – zestawy klas z zewnętrznej biblioteki, na której opiera się aplikacji (np. baza danych, łączenie się
// 				   z nią – to jest kilkanaście-kilkadziesiąt klas; to jest dostarczane przez SpringData).

// 				   Do istnienia jednej klasy potrzebna jest druga – potrzebne są zależności, wykorzystywane w aplikacji
//             	   (przez tworzone w niej klasy); np. np. KsiegController potrzebny jest KsiegService – wywołujemy w
//             	   kontrolerze metody z serwisu, a jeżeli tej zależności nie ma (nie została „wstrzyknięta)”, to
//             	   kontroler nie działa (na tym polega zależność).

// Spring 		 – rodzina frameworków; w momencie ich włączenia do projektu stają się zależnościami (dependencjami),
// 				   którymi zarządza Maven / Gradle; sam Spring nie jest frameworkiem, frameworkami są np. SpringBoot,
// 				   SpringWeb, SpringData, SpringCloud, SpringWebServices.

// Adnotacje	 – dodatkowe zachowania „schowane” pod oznaczonymi w określony sposób klasami (np. klasa oznaczona
// 				   jako „Service” albo „Entity”.

// Biblioteka vs. framework – „inversion of control”, kto kontroluje „flow” (programista vs. framework):
// https://www.freecodecamp.org/news/the-difference-between-a-framework-and-a-library-bd133054023f/

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

}
