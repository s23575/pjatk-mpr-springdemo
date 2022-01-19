package pl.edu.pjatk.mpr.springdemo.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class KsiegRestControllerTestIT {

    @Autowired

    private MockMvc mockMvc;

    //      < - - Ksiazki - - >

    @Test
    void shouldReturnSuccess_ksiazkaById() throws Exception {       // Wymagane, aby obsłużyć ewentualne błędy
        String expected = new String("{\"id\":1,\"tytul\":\"Zbrodnia i kara\",\"tytulOryg\":\"Priestuplenije i nakazanije\",\"wydania\":[{\"id\":1,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\",\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":1,\"imie\":\"J.P.\",\"nazwisko\":\"ZajÄ\u0085czkowski\"}]},{\"id\":2,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-280-6779-0\",\"oprawa\":\"MIEKKA\",\"cena\":24.99,\"wydawnictwo\":\"Wilga\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":2,\"imie\":\"CzesÅ\u0082aw\",\"nazwisko\":\"JastrzÄ\u0099biec-KozÅ\u0082owski\"}]}],\"autorzy\":[{\"id\":1,\"imie\":\"Fiodor\",\"nazwisko\":\"Dostojewski\",\"dataUr\":1821,\"dataSm\":1881}]}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazka/{id}", 1);
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_ksiazki() throws Exception {
        String expected = new String("[{\"id\":1,\"tytul\":\"Zbrodnia i kara\",\"tytulOryg\":\"Priestuplenije i nakazanije\",\"wydania\":[{\"id\":1,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\",\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":1,\"imie\":\"J.P.\",\"nazwisko\":\"ZajÄ\u0085czkowski\"}]},{\"id\":2,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-280-6779-0\",\"oprawa\":\"MIEKKA\",\"cena\":24.99,\"wydawnictwo\":\"Wilga\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":2,\"imie\":\"CzesÅ\u0082aw\",\"nazwisko\":\"JastrzÄ\u0099biec-KozÅ\u0082owski\"}]}],\"autorzy\":[{\"id\":1,\"imie\":\"Fiodor\",\"nazwisko\":\"Dostojewski\",\"dataUr\":1821,\"dataSm\":1881}]},{\"id\":2,\"tytul\":\"Bracia Karamazow\",\"tytulOryg\":\"Bratya Karamazovy\",\"wydania\":[{\"id\":3,\"rok\":2004,\"numer\":1,\"isbn\":\"978-83-240-1263-3\",\"oprawa\":\"TWARDA\",\"cena\":65.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":3,\"imie\":\"Adam\",\"nazwisko\":\"Pomorski\"}]}],\"autorzy\":[{\"id\":1,\"imie\":\"Fiodor\",\"nazwisko\":\"Dostojewski\",\"dataUr\":1821,\"dataSm\":1881}]},{\"id\":3,\"tytul\":\"Katedra\",\"tytulOryg\":null,\"wydania\":[{\"id\":4,\"rok\":2017,\"numer\":null,\"isbn\":\"978-83-08-07320-9\",\"oprawa\":\"MIEKKA\",\"cena\":24.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":2,\"imie\":\"Jacek\",\"nazwisko\":\"Dukaj\",\"dataUr\":1974,\"dataSm\":null}]},{\"id\":4,\"tytul\":\"Imperium chmur\",\"tytulOryg\":null,\"wydania\":[{\"id\":5,\"rok\":2020,\"numer\":1,\"isbn\":\"978-83-08-07471-8\",\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":2,\"imie\":\"Jacek\",\"nazwisko\":\"Dukaj\",\"dataUr\":1974,\"dataSm\":null}]},{\"id\":5,\"tytul\":\"JÄ\u0085dro ciemnoÅ\u009Bci\",\"tytulOryg\":\"Heart of Darkness\",\"wydania\":[{\"id\":6,\"rok\":2021,\"numer\":2,\"isbn\":\"978-83-240-6405-2\",\"oprawa\":\"TWARDA\",\"cena\":39.99,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":4,\"imie\":\"Magda \",\"nazwisko\":\"Heydel\"}]}],\"autorzy\":[{\"id\":3,\"imie\":\"Joseph\",\"nazwisko\":\"Conrad\",\"dataUr\":1857,\"dataSm\":1924}]},{\"id\":6,\"tytul\":\"Serce ciemnoÅ\u009Bci\",\"tytulOryg\":\"Heart of Darkness\",\"wydania\":[{\"id\":7,\"rok\":2017,\"numer\":1,\"isbn\":\"978-83-08-06417-7\",\"oprawa\":\"TWARDA\",\"cena\":28.0,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":5,\"imie\":\"Jacek\",\"nazwisko\":\"Dukaj\"}]}],\"autorzy\":[{\"id\":3,\"imie\":\"Joseph\",\"nazwisko\":\"Conrad\",\"dataUr\":1857,\"dataSm\":1924}]},{\"id\":7,\"tytul\":\"Lord Jim\",\"tytulOryg\":\"Lord Jim\",\"wydania\":[{\"id\":8,\"rok\":2021,\"numer\":2,\"isbn\":\"978-83-240-6401-4\",\"oprawa\":\"TWARDA\",\"cena\":49.99,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":6,\"imie\":\"MichaÅ\u0082\",\"nazwisko\":\"KÅ\u0082obukowski\"}]}],\"autorzy\":[{\"id\":3,\"imie\":\"Joseph\",\"nazwisko\":\"Conrad\",\"dataUr\":1857,\"dataSm\":1924}]},{\"id\":8,\"tytul\":\"JadÄ\u0085c do Babadag\",\"tytulOryg\":null,\"wydania\":[{\"id\":9,\"rok\":2021,\"numer\":5,\"isbn\":\"978-83-8191-140-5\",\"oprawa\":\"TWARDA\",\"cena\":44.9,\"wydawnictwo\":\"Czarne\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":4,\"imie\":\"Andrzej\",\"nazwisko\":\"Stasiuk\",\"dataUr\":1960,\"dataSm\":null}]},{\"id\":9,\"tytul\":\"Ziemia obiecana\",\"tytulOryg\":null,\"wydania\":[{\"id\":11,\"rok\":2014,\"numer\":null,\"isbn\":\"978-83-6105-669-0\",\"oprawa\":\"TWARDA\",\"cena\":35.0,\"wydawnictwo\":\"Ossolineum\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":5,\"imie\":\"WÅ\u0082adysÅ\u0082aw\",\"nazwisko\":\"Reymont\",\"dataUr\":1867,\"dataSm\":1925}]},{\"id\":10,\"tytul\":\"Kolor magii\",\"tytulOryg\":\"The Colour of Magic\",\"wydania\":[{\"id\":12,\"rok\":2021,\"numer\":null,\"isbn\":\"978-83-8234-081-5\",\"oprawa\":\"MIEKKA\",\"cena\":35.0,\"wydawnictwo\":\"PrÃ³szyÅ\u0084ski i s-ka\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":7,\"imie\":\"Piotr W.\",\"nazwisko\":\"Cholewa\"}]},{\"id\":13,\"rok\":2005,\"numer\":null,\"isbn\":\"978-83-7469-097-3\",\"oprawa\":\"MIEKKA\",\"cena\":29.9,\"wydawnictwo\":\"PrÃ³szyÅ\u0084ski i s-ka\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":7,\"imie\":\"Piotr W.\",\"nazwisko\":\"Cholewa\"}]}],\"autorzy\":[{\"id\":6,\"imie\":\"Terry\",\"nazwisko\":\"Pratchett\",\"dataUr\":1948,\"dataSm\":2015}]},{\"id\":11,\"tytul\":\"Moby Dick czyli biaÅ\u0082y wieloryb\",\"tytulOryg\":\"Moby-Dick; or, The Whale\",\"wydania\":[{\"id\":14,\"rok\":2018,\"numer\":null,\"isbn\":\"978-83-06-03500-1\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":8,\"imie\":\"BronisÅ\u0082aw \",\"nazwisko\":\"ZieliÅ\u0084ski\"}]}],\"autorzy\":[{\"id\":7,\"imie\":\"Herman\",\"nazwisko\":\"Melville\",\"dataUr\":1819,\"dataSm\":1891}]},{\"id\":12,\"tytul\":\"Gepard\",\"tytulOryg\":\"Il Gattopardo\",\"wydania\":[{\"id\":15,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-950-4558-5\",\"oprawa\":\"MIEKKA\",\"cena\":35.0,\"wydawnictwo\":\"CzuÅ\u0082y BarbarzyÅ\u0084ca\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":9,\"imie\":\"StanisÅ\u0082aw\",\"nazwisko\":\"Kasprzysiak\"}]}],\"autorzy\":[{\"id\":8,\"imie\":\"Giuseppe\",\"nazwisko\":\"Tomasi di Lampedusa\",\"dataUr\":1896,\"dataSm\":1957}]},{\"id\":13,\"tytul\":\"Ulisses\",\"tytulOryg\":\"Ulysses\",\"wydania\":[{\"id\":16,\"rok\":2012,\"numer\":null,\"isbn\":\"978-83-240-1879-6\",\"oprawa\":\"TWARDA\",\"cena\":64.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":10,\"imie\":\"Maciej\",\"nazwisko\":\"SÅ\u0082omczyÅ\u0084ski\"}]},{\"id\":17,\"rok\":2021,\"numer\":null,\"isbn\":\"978-83-665-1142-2\",\"oprawa\":\"TWARDA\",\"cena\":69.9,\"wydawnictwo\":\"Officyna\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":11,\"imie\":\"Maciej\",\"nazwisko\":\"Å\u009Awierkocki\"}]}],\"autorzy\":[{\"id\":9,\"imie\":\"James\",\"nazwisko\":\"Joyce\",\"dataUr\":1882,\"dataSm\":1941}]},{\"id\":14,\"tytul\":\"Mistrz i MaÅ\u0082gorzata\",\"tytulOryg\":\"Mastier i Margarita \",\"wydania\":[{\"id\":18,\"rok\":2018,\"numer\":null,\"isbn\":\"978-83-06-03527-8\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":12,\"imie\":\"Irena\",\"nazwisko\":\"Lewandowska\"},{\"id\":13,\"imie\":\"Witold\",\"nazwisko\":\"DÄ\u0085browski\"}]}],\"autorzy\":[{\"id\":10,\"imie\":\"MichaiÅ\u0082\",\"nazwisko\":\"BuÅ\u0082hakow\",\"dataUr\":1891,\"dataSm\":1940}]},{\"id\":15,\"tytul\":\"KrÃ³l\",\"tytulOryg\":null,\"wydania\":[{\"id\":19,\"rok\":2016,\"numer\":1,\"isbn\":\"978-83-080-6224-1\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":20,\"rok\":2020,\"numer\":2,\"isbn\":\"978-83-080-7095-6\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":11,\"imie\":\"Szczepan\",\"nazwisko\":\"Twardoch\",\"dataUr\":1979,\"dataSm\":null}]},{\"id\":16,\"tytul\":\"KrÃ³lestwo\",\"tytulOryg\":null,\"wydania\":[{\"id\":21,\"rok\":2018,\"numer\":1,\"isbn\":\"978-83-080-6800-7\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":11,\"imie\":\"Szczepan\",\"nazwisko\":\"Twardoch\",\"dataUr\":1979,\"dataSm\":null}]},{\"id\":17,\"tytul\":\"W stronÄ\u0099 Swanna\",\"tytulOryg\":\"Du cÃ´tÃ© de chez Swann\",\"wydania\":[{\"id\":22,\"rok\":2018,\"numer\":null,\"isbn\":\"978-83-624-0979-2\",\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Officyna\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":14,\"imie\":\"Krystyna \",\"nazwisko\":\"Rodowska\"}]}],\"autorzy\":[{\"id\":12,\"imie\":\"Marcel\",\"nazwisko\":\"Proust\",\"dataUr\":1871,\"dataSm\":1922}]},{\"id\":18,\"tytul\":\"KsiÄ\u0099gi Jakubowe\",\"tytulOryg\":null,\"wydania\":[{\"id\":23,\"rok\":2021,\"numer\":2,\"isbn\":\"978-83-080-7328-5\",\"oprawa\":\"TWARDA\",\"cena\":74.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":13,\"imie\":\"Olga\",\"nazwisko\":\"Tokarczuk\",\"dataUr\":1962,\"dataSm\":null}]},{\"id\":19,\"tytul\":\"Pierwszy krok w chmurach. Opowiadania\",\"tytulOryg\":null,\"wydania\":[{\"id\":24,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-244-1027-9\",\"oprawa\":\"MIEKKA\",\"cena\":29.9,\"wydawnictwo\":\"Iskry\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":14,\"imie\":\"Marek\",\"nazwisko\":\"HÅ\u0082asko\",\"dataUr\":1934,\"dataSm\":1969}]},{\"id\":20,\"tytul\":\"Utwory wybrane. Dramaty, sÅ\u0082uchowiska, scenariusze\",\"tytulOryg\":null,\"wydania\":[{\"id\":25,\"rok\":2017,\"numer\":null,\"isbn\":\"978-83-06-03406-6\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":15,\"imie\":\"Antoni\",\"nazwisko\":\"Libera\"}]}],\"autorzy\":[{\"id\":15,\"imie\":\"Samuel\",\"nazwisko\":\"Beckett\",\"dataUr\":1906,\"dataSm\":1989}]}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazki");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_addedKsiazka() throws Exception {
        String expected = new String("{\"id\":21,\"tytul\":\"KonajÄ\u0085ce zwierzÄ\u0099\",\"tytulOryg\":\"The Dying Animal\",\"wydania\":[{\"id\":26,\"rok\":2022,\"numer\":2,\"isbn\":\"978-83-08-07475-6\",\"oprawa\":\"TWARDA\",\"cena\":44.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":16,\"imie\":\"Jolanta\",\"nazwisko\":\"Kozak\"}]}],\"autorzy\":[{\"id\":16,\"imie\":\"Philip\",\"nazwisko\":\"Roth\",\"dataUr\":1933,\"dataSm\":2018}]}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazka/dodaj");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_addedKsiazkaDoWydan() throws Exception {
        String expected = new String("");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazka/dodaj");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_updatedKsiazka() throws Exception {
        String expected = new String("1");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazka/zmien");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_getAllByIdIsGreaterThan() throws Exception {
        String expected = new String("[{\"id\":6,\"tytul\":\"Serce ciemnoÅ\u009Bci\",\"tytulOryg\":\"Heart of Darkness\",\"wydania\":[{\"id\":7,\"rok\":2017,\"numer\":1,\"isbn\":\"978-83-08-06417-7\",\"oprawa\":\"TWARDA\",\"cena\":28.0,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":5,\"imie\":\"Jacek\",\"nazwisko\":\"Dukaj\"}]}],\"autorzy\":[{\"id\":3,\"imie\":\"Joseph\",\"nazwisko\":\"Conrad\",\"dataUr\":1857,\"dataSm\":1924}]},{\"id\":7,\"tytul\":\"Lord Jim\",\"tytulOryg\":\"Lord Jim\",\"wydania\":[{\"id\":8,\"rok\":2021,\"numer\":2,\"isbn\":\"978-83-240-6401-4\",\"oprawa\":\"TWARDA\",\"cena\":49.99,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":6,\"imie\":\"MichaÅ\u0082\",\"nazwisko\":\"KÅ\u0082obukowski\"}]}],\"autorzy\":[{\"id\":3,\"imie\":\"Joseph\",\"nazwisko\":\"Conrad\",\"dataUr\":1857,\"dataSm\":1924}]},{\"id\":8,\"tytul\":\"JadÄ\u0085c do Babadag\",\"tytulOryg\":null,\"wydania\":[{\"id\":9,\"rok\":2021,\"numer\":5,\"isbn\":\"978-83-8191-140-5\",\"oprawa\":\"TWARDA\",\"cena\":44.9,\"wydawnictwo\":\"Czarne\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":4,\"imie\":\"Andrzej\",\"nazwisko\":\"Stasiuk\",\"dataUr\":1960,\"dataSm\":null}]},{\"id\":9,\"tytul\":\"Ziemia obiecana\",\"tytulOryg\":null,\"wydania\":[{\"id\":11,\"rok\":2014,\"numer\":null,\"isbn\":\"978-83-6105-669-0\",\"oprawa\":\"TWARDA\",\"cena\":35.0,\"wydawnictwo\":\"Ossolineum\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":5,\"imie\":\"WÅ\u0082adysÅ\u0082aw\",\"nazwisko\":\"Reymont\",\"dataUr\":1867,\"dataSm\":1925}]},{\"id\":10,\"tytul\":\"Kolor magii\",\"tytulOryg\":\"The Colour of Magic\",\"wydania\":[{\"id\":12,\"rok\":2021,\"numer\":null,\"isbn\":\"978-83-8234-081-5\",\"oprawa\":\"MIEKKA\",\"cena\":35.0,\"wydawnictwo\":\"PrÃ³szyÅ\u0084ski i s-ka\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":7,\"imie\":\"Piotr W.\",\"nazwisko\":\"Cholewa\"}]},{\"id\":13,\"rok\":2005,\"numer\":null,\"isbn\":\"978-83-7469-097-3\",\"oprawa\":\"MIEKKA\",\"cena\":29.9,\"wydawnictwo\":\"PrÃ³szyÅ\u0084ski i s-ka\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":7,\"imie\":\"Piotr W.\",\"nazwisko\":\"Cholewa\"}]}],\"autorzy\":[{\"id\":6,\"imie\":\"Terry\",\"nazwisko\":\"Pratchett\",\"dataUr\":1948,\"dataSm\":2015}]},{\"id\":11,\"tytul\":\"Moby Dick czyli biaÅ\u0082y wieloryb\",\"tytulOryg\":\"Moby-Dick; or, The Whale\",\"wydania\":[{\"id\":14,\"rok\":2018,\"numer\":null,\"isbn\":\"978-83-06-03500-1\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":8,\"imie\":\"BronisÅ\u0082aw \",\"nazwisko\":\"ZieliÅ\u0084ski\"}]}],\"autorzy\":[{\"id\":7,\"imie\":\"Herman\",\"nazwisko\":\"Melville\",\"dataUr\":1819,\"dataSm\":1891}]},{\"id\":12,\"tytul\":\"Gepard\",\"tytulOryg\":\"Il Gattopardo\",\"wydania\":[{\"id\":15,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-950-4558-5\",\"oprawa\":\"MIEKKA\",\"cena\":35.0,\"wydawnictwo\":\"CzuÅ\u0082y BarbarzyÅ\u0084ca\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":9,\"imie\":\"StanisÅ\u0082aw\",\"nazwisko\":\"Kasprzysiak\"}]}],\"autorzy\":[{\"id\":8,\"imie\":\"Giuseppe\",\"nazwisko\":\"Tomasi di Lampedusa\",\"dataUr\":1896,\"dataSm\":1957}]},{\"id\":13,\"tytul\":\"Ulisses\",\"tytulOryg\":\"Ulysses\",\"wydania\":[{\"id\":16,\"rok\":2012,\"numer\":null,\"isbn\":\"978-83-240-1879-6\",\"oprawa\":\"TWARDA\",\"cena\":64.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":10,\"imie\":\"Maciej\",\"nazwisko\":\"SÅ\u0082omczyÅ\u0084ski\"}]},{\"id\":17,\"rok\":2021,\"numer\":null,\"isbn\":\"978-83-665-1142-2\",\"oprawa\":\"TWARDA\",\"cena\":69.9,\"wydawnictwo\":\"Officyna\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":11,\"imie\":\"Maciej\",\"nazwisko\":\"Å\u009Awierkocki\"}]}],\"autorzy\":[{\"id\":9,\"imie\":\"James\",\"nazwisko\":\"Joyce\",\"dataUr\":1882,\"dataSm\":1941}]},{\"id\":14,\"tytul\":\"Mistrz i MaÅ\u0082gorzata\",\"tytulOryg\":\"Mastier i Margarita \",\"wydania\":[{\"id\":18,\"rok\":2018,\"numer\":null,\"isbn\":\"978-83-06-03527-8\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":12,\"imie\":\"Irena\",\"nazwisko\":\"Lewandowska\"},{\"id\":13,\"imie\":\"Witold\",\"nazwisko\":\"DÄ\u0085browski\"}]}],\"autorzy\":[{\"id\":10,\"imie\":\"MichaiÅ\u0082\",\"nazwisko\":\"BuÅ\u0082hakow\",\"dataUr\":1891,\"dataSm\":1940}]},{\"id\":15,\"tytul\":\"KrÃ³l\",\"tytulOryg\":null,\"wydania\":[{\"id\":19,\"rok\":2016,\"numer\":1,\"isbn\":\"978-83-080-6224-1\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":20,\"rok\":2020,\"numer\":2,\"isbn\":\"978-83-080-7095-6\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":11,\"imie\":\"Szczepan\",\"nazwisko\":\"Twardoch\",\"dataUr\":1979,\"dataSm\":null}]},{\"id\":16,\"tytul\":\"KrÃ³lestwo\",\"tytulOryg\":null,\"wydania\":[{\"id\":21,\"rok\":2018,\"numer\":1,\"isbn\":\"978-83-080-6800-7\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":11,\"imie\":\"Szczepan\",\"nazwisko\":\"Twardoch\",\"dataUr\":1979,\"dataSm\":null}]},{\"id\":17,\"tytul\":\"W stronÄ\u0099 Swanna\",\"tytulOryg\":\"Du cÃ´tÃ© de chez Swann\",\"wydania\":[{\"id\":22,\"rok\":2018,\"numer\":null,\"isbn\":\"978-83-624-0979-2\",\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Officyna\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":14,\"imie\":\"Krystyna \",\"nazwisko\":\"Rodowska\"}]}],\"autorzy\":[{\"id\":12,\"imie\":\"Marcel\",\"nazwisko\":\"Proust\",\"dataUr\":1871,\"dataSm\":1922}]},{\"id\":18,\"tytul\":\"KsiÄ\u0099gi Jakubowe\",\"tytulOryg\":null,\"wydania\":[{\"id\":23,\"rok\":2021,\"numer\":2,\"isbn\":\"978-83-080-7328-5\",\"oprawa\":\"TWARDA\",\"cena\":74.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":13,\"imie\":\"Olga\",\"nazwisko\":\"Tokarczuk\",\"dataUr\":1962,\"dataSm\":null}]},{\"id\":19,\"tytul\":\"Pierwszy krok w chmurach. Opowiadania\",\"tytulOryg\":null,\"wydania\":[{\"id\":24,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-244-1027-9\",\"oprawa\":\"MIEKKA\",\"cena\":29.9,\"wydawnictwo\":\"Iskry\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":14,\"imie\":\"Marek\",\"nazwisko\":\"HÅ\u0082asko\",\"dataUr\":1934,\"dataSm\":1969}]},{\"id\":20,\"tytul\":\"Utwory wybrane. Dramaty, sÅ\u0082uchowiska, scenariusze\",\"tytulOryg\":null,\"wydania\":[{\"id\":25,\"rok\":2017,\"numer\":null,\"isbn\":\"978-83-06-03406-6\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":15,\"imie\":\"Antoni\",\"nazwisko\":\"Libera\"}]}],\"autorzy\":[{\"id\":15,\"imie\":\"Samuel\",\"nazwisko\":\"Beckett\",\"dataUr\":1906,\"dataSm\":1989}]}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazki/greater");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_getAllByIdIsGreaterThanAndTytulIsContaining() throws Exception {
        String expected = new String("[{\"id\":15,\"tytul\":\"KrÃ³l\",\"tytulOryg\":null,\"wydania\":[{\"id\":19,\"rok\":2016,\"numer\":1,\"isbn\":\"978-83-080-6224-1\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":20,\"rok\":2020,\"numer\":2,\"isbn\":\"978-83-080-7095-6\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":11,\"imie\":\"Szczepan\",\"nazwisko\":\"Twardoch\",\"dataUr\":1979,\"dataSm\":null}]},{\"id\":16,\"tytul\":\"KrÃ³lestwo\",\"tytulOryg\":null,\"wydania\":[{\"id\":21,\"rok\":2018,\"numer\":1,\"isbn\":\"978-83-080-6800-7\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[]}],\"autorzy\":[{\"id\":11,\"imie\":\"Szczepan\",\"nazwisko\":\"Twardoch\",\"dataUr\":1979,\"dataSm\":null}]}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazki/greatername");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_ksiazkaExistsById() throws Exception {
        String expected = new String("true");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazka/istnieje/{id}", 1);
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_KsiazkaDeletedById() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazka/usun/{id}", 1);
        mockMvc.perform(get("/ksieg/ksiazka/istnieje/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"))
                .andDo(result -> {      // Przetestowanie usuwania rekordu (książki)
                    mockMvc.perform(getRequestBuilder)
                            .andDo(print())
                            .andExpect(status().isOk());
                })
                .andDo(result -> {
                    mockMvc.perform(get("/ksieg/ksiazka/istnieje/{id}", 1))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(content().string("false"));
                });
    }


    //      < - - Autorzy - - >
    @Test
    void shouldReturnSuccess_autorById() throws Exception {
        String expected = new String("{\"id\":7,\"imie\":\"Herman\",\"nazwisko\":\"Melville\",\"dataUr\":1819,\"dataSm\":1891}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/autor/id/{id}", 7);
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_autorByNazwisko() throws Exception {
        String expected = new String("{\"id\":11,\"imie\":\"Szczepan\",\"nazwisko\":\"Twardoch\",\"dataUr\":1979,\"dataSm\":null}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/autor/nazwisko/{nazwisko}", "Twardoch");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnError_autorByNazwisko() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/autor/nazwisko/{nazwisko}", "Sienkiewicz");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }


    @Test
    void shouldReturnSuccess_addedAutorParametry() throws Exception {
        String expected = new String("{\"id\":16,\"imie\":\"Charles\",\"nazwisko\":\"Bukowski\",\"dataUr\":1920,\"dataSm\":1994}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/autor/dodaj")
                .param("imie", "Charles").param("nazwisko", "Bukowski")
                .param("dataUr", "1920").param("dataSm", "1994");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_autorzy() throws Exception {
        String expected = new String("[{\"id\":1,\"imie\":\"Fiodor\",\"nazwisko\":\"Dostojewski\",\"dataUr\":1821,\"dataSm\":1881},{\"id\":2,\"imie\":\"Jacek\",\"nazwisko\":\"Dukaj\",\"dataUr\":1974,\"dataSm\":null},{\"id\":3,\"imie\":\"Joseph\",\"nazwisko\":\"Conrad\",\"dataUr\":1857,\"dataSm\":1924},{\"id\":4,\"imie\":\"Andrzej\",\"nazwisko\":\"Stasiuk\",\"dataUr\":1960,\"dataSm\":null},{\"id\":5,\"imie\":\"WÅ\u0082adysÅ\u0082aw\",\"nazwisko\":\"Reymont\",\"dataUr\":1867,\"dataSm\":1925},{\"id\":6,\"imie\":\"Terry\",\"nazwisko\":\"Pratchett\",\"dataUr\":1948,\"dataSm\":2015},{\"id\":7,\"imie\":\"Herman\",\"nazwisko\":\"Melville\",\"dataUr\":1819,\"dataSm\":1891},{\"id\":8,\"imie\":\"Giuseppe\",\"nazwisko\":\"Tomasi di Lampedusa\",\"dataUr\":1896,\"dataSm\":1957},{\"id\":9,\"imie\":\"James\",\"nazwisko\":\"Joyce\",\"dataUr\":1882,\"dataSm\":1941},{\"id\":10,\"imie\":\"MichaiÅ\u0082\",\"nazwisko\":\"BuÅ\u0082hakow\",\"dataUr\":1891,\"dataSm\":1940},{\"id\":11,\"imie\":\"Szczepan\",\"nazwisko\":\"Twardoch\",\"dataUr\":1979,\"dataSm\":null},{\"id\":12,\"imie\":\"Marcel\",\"nazwisko\":\"Proust\",\"dataUr\":1871,\"dataSm\":1922},{\"id\":13,\"imie\":\"Olga\",\"nazwisko\":\"Tokarczuk\",\"dataUr\":1962,\"dataSm\":null},{\"id\":14,\"imie\":\"Marek\",\"nazwisko\":\"HÅ\u0082asko\",\"dataUr\":1934,\"dataSm\":1969},{\"id\":15,\"imie\":\"Samuel\",\"nazwisko\":\"Beckett\",\"dataUr\":1906,\"dataSm\":1989}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/autorzy");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    //      < - - Wydania - - >

    @Test
    void shouldReturnSuccess_wydanieById() throws Exception {
        String expected = new String("{\"id\":19,\"rok\":2016,\"numer\":1,\"isbn\":\"978-83-080-6224-1\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[]}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/wydanie/{id}", 19);
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_addedWydania() throws Exception {
        String expected = new String("[{\"id\":26,\"rok\":2016,\"numer\":4,\"isbn\":\"978-83-804-9367-4\",\"oprawa\":\"TWARDA\",\"cena\":34.9,\"wydawnictwo\":\"Czarne\",\"czyDostepne\":true,\"tlumacze\":null},{\"id\":27,\"rok\":2011,\"numer\":7,\"isbn\":\"978-83-7536-265-7\",\"oprawa\":\"MIEKKA\",\"cena\":29.5,\"wydawnictwo\":\"Czarne\",\"czyDostepne\":false,\"tlumacze\":null}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/wydania/dodaj");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_wydania() throws Exception {
        String expected = new String("[{\"id\":1,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\",\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":1,\"imie\":\"J.P.\",\"nazwisko\":\"ZajÄ\u0085czkowski\"}]},{\"id\":2,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-280-6779-0\",\"oprawa\":\"MIEKKA\",\"cena\":24.99,\"wydawnictwo\":\"Wilga\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":2,\"imie\":\"CzesÅ\u0082aw\",\"nazwisko\":\"JastrzÄ\u0099biec-KozÅ\u0082owski\"}]},{\"id\":3,\"rok\":2004,\"numer\":1,\"isbn\":\"978-83-240-1263-3\",\"oprawa\":\"TWARDA\",\"cena\":65.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":3,\"imie\":\"Adam\",\"nazwisko\":\"Pomorski\"}]},{\"id\":4,\"rok\":2017,\"numer\":null,\"isbn\":\"978-83-08-07320-9\",\"oprawa\":\"MIEKKA\",\"cena\":24.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":5,\"rok\":2020,\"numer\":1,\"isbn\":\"978-83-08-07471-8\",\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":6,\"rok\":2021,\"numer\":2,\"isbn\":\"978-83-240-6405-2\",\"oprawa\":\"TWARDA\",\"cena\":39.99,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":4,\"imie\":\"Magda \",\"nazwisko\":\"Heydel\"}]},{\"id\":7,\"rok\":2017,\"numer\":1,\"isbn\":\"978-83-08-06417-7\",\"oprawa\":\"TWARDA\",\"cena\":28.0,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":5,\"imie\":\"Jacek\",\"nazwisko\":\"Dukaj\"}]},{\"id\":8,\"rok\":2021,\"numer\":2,\"isbn\":\"978-83-240-6401-4\",\"oprawa\":\"TWARDA\",\"cena\":49.99,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":6,\"imie\":\"MichaÅ\u0082\",\"nazwisko\":\"KÅ\u0082obukowski\"}]},{\"id\":9,\"rok\":2021,\"numer\":5,\"isbn\":\"978-83-8191-140-5\",\"oprawa\":\"TWARDA\",\"cena\":44.9,\"wydawnictwo\":\"Czarne\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":10,\"rok\":2008,\"numer\":1,\"isbn\":\"978-83-8739-197-2\",\"oprawa\":\"TWARDA\",\"cena\":39.0,\"wydawnictwo\":\"Czarne\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":11,\"rok\":2014,\"numer\":null,\"isbn\":\"978-83-6105-669-0\",\"oprawa\":\"TWARDA\",\"cena\":35.0,\"wydawnictwo\":\"Ossolineum\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":12,\"rok\":2021,\"numer\":null,\"isbn\":\"978-83-8234-081-5\",\"oprawa\":\"MIEKKA\",\"cena\":35.0,\"wydawnictwo\":\"PrÃ³szyÅ\u0084ski i s-ka\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":7,\"imie\":\"Piotr W.\",\"nazwisko\":\"Cholewa\"}]},{\"id\":13,\"rok\":2005,\"numer\":null,\"isbn\":\"978-83-7469-097-3\",\"oprawa\":\"MIEKKA\",\"cena\":29.9,\"wydawnictwo\":\"PrÃ³szyÅ\u0084ski i s-ka\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":7,\"imie\":\"Piotr W.\",\"nazwisko\":\"Cholewa\"}]},{\"id\":14,\"rok\":2018,\"numer\":null,\"isbn\":\"978-83-06-03500-1\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":8,\"imie\":\"BronisÅ\u0082aw \",\"nazwisko\":\"ZieliÅ\u0084ski\"}]},{\"id\":15,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-950-4558-5\",\"oprawa\":\"MIEKKA\",\"cena\":35.0,\"wydawnictwo\":\"CzuÅ\u0082y BarbarzyÅ\u0084ca\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":9,\"imie\":\"StanisÅ\u0082aw\",\"nazwisko\":\"Kasprzysiak\"}]},{\"id\":16,\"rok\":2012,\"numer\":null,\"isbn\":\"978-83-240-1879-6\",\"oprawa\":\"TWARDA\",\"cena\":64.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":10,\"imie\":\"Maciej\",\"nazwisko\":\"SÅ\u0082omczyÅ\u0084ski\"}]},{\"id\":17,\"rok\":2021,\"numer\":null,\"isbn\":\"978-83-665-1142-2\",\"oprawa\":\"TWARDA\",\"cena\":69.9,\"wydawnictwo\":\"Officyna\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":11,\"imie\":\"Maciej\",\"nazwisko\":\"Å\u009Awierkocki\"}]},{\"id\":18,\"rok\":2018,\"numer\":null,\"isbn\":\"978-83-06-03527-8\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":12,\"imie\":\"Irena\",\"nazwisko\":\"Lewandowska\"},{\"id\":13,\"imie\":\"Witold\",\"nazwisko\":\"DÄ\u0085browski\"}]},{\"id\":19,\"rok\":2016,\"numer\":1,\"isbn\":\"978-83-080-6224-1\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":20,\"rok\":2020,\"numer\":2,\"isbn\":\"978-83-080-7095-6\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":21,\"rok\":2018,\"numer\":1,\"isbn\":\"978-83-080-6800-7\",\"oprawa\":\"MIEKKA\",\"cena\":44.9,\"wydawnictwo\":\"Znak\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":22,\"rok\":2018,\"numer\":null,\"isbn\":\"978-83-624-0979-2\",\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Officyna\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":14,\"imie\":\"Krystyna \",\"nazwisko\":\"Rodowska\"}]},{\"id\":23,\"rok\":2021,\"numer\":2,\"isbn\":\"978-83-080-7328-5\",\"oprawa\":\"TWARDA\",\"cena\":74.9,\"wydawnictwo\":\"Wydawnictwo Literackie\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":24,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-244-1027-9\",\"oprawa\":\"MIEKKA\",\"cena\":29.9,\"wydawnictwo\":\"Iskry\",\"czyDostepne\":true,\"tlumacze\":[]},{\"id\":25,\"rok\":2017,\"numer\":null,\"isbn\":\"978-83-06-03406-6\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":15,\"imie\":\"Antoni\",\"nazwisko\":\"Libera\"}]}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/wydania");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_wydaniaTowTop() throws Exception {
        String expected = new String("[{\"id\":25,\"rok\":2017,\"numer\":null,\"isbn\":\"978-83-06-03406-6\",\"oprawa\":\"TWARDA\",\"cena\":59.0,\"wydawnictwo\":\"PaÅ\u0084stwowy Instytut Wydawniczy\",\"czyDostepne\":true,\"tlumacze\":[{\"id\":15,\"imie\":\"Antoni\",\"nazwisko\":\"Libera\"}]},{\"id\":24,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-244-1027-9\",\"oprawa\":\"MIEKKA\",\"cena\":29.9,\"wydawnictwo\":\"Iskry\",\"czyDostepne\":true,\"tlumacze\":[]}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/wydania/top");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_przykWyd() throws Exception {
//        String expected = new String("{\"id\":1,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\"," +
//                "\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czydostepne\":true,\"tlumacz\":null}");
        String expected = new String("{\"id\":7,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\"," +
                "\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czydostepne\":true,\"tlumacz\":null}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/przykwyd");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    //      < - - Tłumacze - - >

    @Test
    void shouldReturnSuccess_tlumaczById() throws Exception {
        String expected = new String("{\"id\":4,\"imie\":\"Magda \",\"nazwisko\":\"Heydel\"}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/tlumacz/{id}", 4);
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_tlumacze() throws Exception {
        String expected = new String("[{\"id\":1,\"imie\":\"J.P.\",\"nazwisko\":\"ZajÄ\u0085czkowski\"},{\"id\":2,\"imie\":\"CzesÅ\u0082aw\",\"nazwisko\":\"JastrzÄ\u0099biec-KozÅ\u0082owski\"},{\"id\":3,\"imie\":\"Adam\",\"nazwisko\":\"Pomorski\"},{\"id\":4,\"imie\":\"Magda \",\"nazwisko\":\"Heydel\"},{\"id\":5,\"imie\":\"Jacek\",\"nazwisko\":\"Dukaj\"},{\"id\":6,\"imie\":\"MichaÅ\u0082\",\"nazwisko\":\"KÅ\u0082obukowski\"},{\"id\":7,\"imie\":\"Piotr W.\",\"nazwisko\":\"Cholewa\"},{\"id\":8,\"imie\":\"BronisÅ\u0082aw \",\"nazwisko\":\"ZieliÅ\u0084ski\"},{\"id\":9,\"imie\":\"StanisÅ\u0082aw\",\"nazwisko\":\"Kasprzysiak\"},{\"id\":10,\"imie\":\"Maciej\",\"nazwisko\":\"SÅ\u0082omczyÅ\u0084ski\"},{\"id\":11,\"imie\":\"Maciej\",\"nazwisko\":\"Å\u009Awierkocki\"},{\"id\":12,\"imie\":\"Irena\",\"nazwisko\":\"Lewandowska\"},{\"id\":13,\"imie\":\"Witold\",\"nazwisko\":\"DÄ\u0085browski\"},{\"id\":14,\"imie\":\"Krystyna \",\"nazwisko\":\"Rodowska\"},{\"id\":15,\"imie\":\"Antoni\",\"nazwisko\":\"Libera\"}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/tlumacze");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

}
