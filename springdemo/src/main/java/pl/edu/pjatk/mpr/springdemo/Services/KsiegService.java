package pl.edu.pjatk.mpr.springdemo.Services;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.mpr.springdemo.Models.*;
import pl.edu.pjatk.mpr.springdemo.Repositories.KsiazkaRepository;
import pl.edu.pjatk.mpr.springdemo.Repositories.WydanieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KsiegService {

    private final KsiazkaRepository ksiazkaRepository;
    private final WydanieRepository wydanieRepository;
    // Wstrzynięcie można zrobić przez "Autowired", analogicznie, jak w przypadku serwisów i kontrolera

    public KsiegService(KsiazkaRepository ksiazkaRepository, WydanieRepository wydanieRepository) {
        this.ksiazkaRepository = ksiazkaRepository;
        this.wydanieRepository = wydanieRepository;
    }
    // Wstrzyknięcie w serwisie, żeby to rozgraniczyć - nie w kontrolerze; z tego można teraz korzystać w metodach

    //<-- Ksiazki -->

    public Ksiazka getPrzykKsiazk() {
        Wydanie wyd1 = new Wydanie(null,2015,1,"978-83-777-9221-6", Oprawa.TWARDA,49.9,"Znak",true, null);
        Wydanie wyd2 = new Wydanie(null,2019,null,"978-83-280-6779-0",Oprawa.MIEKKA,24.99,"Wilga",true,null);
        List<Wydanie> wydanie = List.of(wyd1, wyd2);
//        List<Wydanie> wydanie = getWszystkWyd();
//        List<Wydanie> wydanie = getWszystkPrzykWyd();
        List<Autor> autor = List.of(new Autor(null,"Fiodor","Dostojewski",1821,1881,null));
        Ksiazka ksiazka = new Ksiazka(null, "Zbrodnia i kara","Priestuplenije i nakazanije",wydanie,autor);
        return ksiazkaRepository.save(ksiazka);
    }

    public List<Ksiazka>getWszystkKsiazk() {
        return ksiazkaRepository.findAll();
    }

    public Ksiazka getKsiazkaById(Integer id) {
        Optional<Ksiazka> byId = ksiazkaRepository.findById(id);
        return byId.orElseThrow(RuntimeException::new);
    }

    public int updateKsiazka(){
        return ksiazkaRepository.updateKsiazka("Nowy przykladowy tytul",15);
    }

    //<-- Autorzy -->

    public Autor getPrzykAutor() {
        return new Autor(1,"Fiodor","Dostojewski",1821,1881,null);
    }

    public Autor getPrzykAutorArugm(String imie, String nazwisko, Integer dataur) {
        return new Autor(1, imie, nazwisko, dataur, null,null);
    }

    //<-- Wydania -->

    public Wydanie getPrzykWyd() {
        Wydanie wydanie = new Wydanie(null,2015,1,"978-83-777-9221-6", Oprawa.TWARDA,49.9,"Znak",true, null);
        return wydanieRepository.save(wydanie);
    }

    public List<Wydanie>getWszystkPrzykWyd() {
        Wydanie wyd1 = new Wydanie(null,2015,1,"978-83-777-9221-6", Oprawa.TWARDA,49.9,"Znak",true, null);
        Wydanie wyd2 = new Wydanie(null,2019,null,"978-83-280-6779-0",Oprawa.MIEKKA,24.99,"Wilga",true,null);
        List<Wydanie> wydania = List.of(wyd1, wyd2);
        return wydanieRepository.saveAll(wydania);
    }

    public List<Wydanie>getWszystkWyd() {
        return wydanieRepository.findAll();
    }

//    public void updateKsiazka(){
//        ksiazkaRepository.updateKsiazka("Testowy",1);
//    }
}
