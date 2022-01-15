package pl.edu.pjatk.mpr.springdemo.Services;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.mpr.springdemo.Models.Autor;
import pl.edu.pjatk.mpr.springdemo.Models.Ksiazka;
import pl.edu.pjatk.mpr.springdemo.Models.Oprawa;
import pl.edu.pjatk.mpr.springdemo.Models.Wydanie;

import java.util.List;

@Service
public class KsiegService {

    public Ksiazka getPrzykKsiazk() {
        Wydanie wyd1 = new Wydanie(1,2015,1,"978-83-777-9221-6", Oprawa.TWARDA,49.9,"Znak",true);
        Wydanie wyd2 = new Wydanie(2,2019,"978-83-280-6779-0",Oprawa.MIEKKA,24.99,"Wilga",true);
        List<Wydanie> wydania = List.of(wyd1, wyd2);
        return new Ksiazka(1, "Zbrodnia i kara","Priestuplenije i nakazanije",wydania);
    }

    public Autor getPrzykAutor() {
        return new Autor(1,"Fiodor","Dostojewski",1821,1881);
    }

    public Wydanie getPrzykWyd() {
        return new Wydanie(1,2015,1,"978-83-777-9221-6", Oprawa.TWARDA,49.9,"Znak",true);
    }

    public Autor getPrzykAutorArugm(String imie, String nazwisko, Integer dataur) {
        return new Autor(1, imie, nazwisko, dataur, null);
    }
}
