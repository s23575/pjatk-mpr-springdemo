package pl.edu.pjatk.mpr.springdemo.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class KsiegRestControllerTestIT {

    @Autowired

    private MockMvc mockMvc;

    //<-- Ksiazka -->

    @Test
    void shouldReturnSuccess_przykKsiazk() throws Exception { // To musi być, żeby obsłużyć ewentualne błędy
//        String expected = new String("{\"id\":1,\"tytul\":\"Zbrodnia i kara\",\"tytuloryg\":\"Priestuplenije " +
//                "i nakazanije\",\"wydanie\":[{\"id\":1,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\"," +
//                "\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czydostepne\":true,\"tlumacz\":null}," +
//                "{\"id\":2,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-280-6779-0\",\"oprawa\":\"MIEKKA\"," +
//                "\"cena\":24.99,\"wydawnictwo\":\"Wilga\",\"czydostepne\":true,\"tlumacz\":null}],\"autorzy\":[{\"id\":1," +
//                "\"imie\":\"Fiodor\",\"nazwisko\":\"Dostojewski\",\"dataur\":1821,\"datasm\":1881}]}");
        String expected = new String("{\"id\":1,\"tytul\":\"Zbrodnia i kara\",\"tytuloryg\":\"Priestuplenije " +
                "i nakazanije\",\"wydanie\":[{\"id\":1,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\"," +
                "\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czydostepne\":true,\"tlumacz\":null}," +
                "{\"id\":2,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-280-6779-0\",\"oprawa\":\"MIEKKA\"," +
                "\"cena\":24.99,\"wydawnictwo\":\"Wilga\",\"czydostepne\":true,\"tlumacz\":null}],\"autorzy\":[{\"id\":2," +
                "\"imie\":\"Fiodor\",\"nazwisko\":\"Dostojewski\",\"dataur\":1821,\"datasm\":1881}]}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/przykksiazk");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_wszystkKsiazk() throws Exception {
        String expected = new String("[]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/ksiazki");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_updateKsiazka() throws Exception {
        String expected = new String("0");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/zmientytul");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_getKsiazkiByIdIsGreaterThan() throws Exception {
        String expected = new String("[]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/greater");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_getKsiazkiByIdIsGreaterThanAndTytulIsContaining() throws Exception {
        String expected = new String("[]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/greatername");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_existsKsiazkaById() throws Exception {
//        String expected = new String("false");
        String expected = new String("true");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/exists/{id}", 1);
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_deleteKsiazkaById() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/delete/{id}", 1);
        mockMvc.perform(get("/ksieg/przykksiazk"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(result -> {
                    mockMvc.perform(get("/ksieg/exists/{id}", 1))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(content().string("true"));
                })
                .andDo(result -> {
                    mockMvc.perform(getRequestBuilder)
                            .andDo(print())
                            .andExpect(status().isOk());
                })
                .andDo(result -> {
                    mockMvc.perform(get("/ksieg/exists/{id}", 1))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(content().string("false"));
                });
    }

    //<-- Autor -->

    @Test
    void shouldReturnSuccess_przykAutor() throws Exception {
        String expected = new String("{\"id\":1,\"imie\":\"Fiodor\",\"nazwisko\":\"Dostojewski\",\"dataur\":1821," +
                "\"datasm\":1881}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/przykaut");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_przykAutorArgum() throws Exception {
        String expected = new String("{\"id\":1,\"imie\":\"Jacek\",\"nazwisko\":\"Dukaj\",\"dataur\":1974," +
                "\"datasm\":null}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/przykautoiminazw");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_przykAutoParam() throws Exception {
        String expected = new String("{\"id\":1,\"imie\":\"jacek\",\"nazwisko\":\"dukaj\",\"dataur\":null," +
                "\"datasm\":null}");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/przykautoimienazwparam")
                .param("imie", "jacek").param("nazwisko", "dukaj");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_getAutorById() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/autor/{nazwisko}", "Dukaj");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    //<-- Wydanie -->


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

    @Test
    void shouldReturnSuccess_wszystkPrzykWyd() throws Exception {
//        String expected = new String("[{\"id\":1,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\"," +
//                "\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czydostepne\":true,\"tlumacz\":null}," +
//                "{\"id\":2,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-280-6779-0\",\"oprawa\":\"MIEKKA\"," +
//                "\"cena\":24.99,\"wydawnictwo\":\"Wilga\",\"czydostepne\":true,\"tlumacz\":null}]");
        String expected = new String("[{\"id\":5,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\"," +
                "\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czydostepne\":true,\"tlumacz\":null}," +
                "{\"id\":6,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-280-6779-0\",\"oprawa\":\"MIEKKA\"," +
                "\"cena\":24.99,\"wydawnictwo\":\"Wilga\",\"czydostepne\":true,\"tlumacz\":null}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/przykwydania");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void shouldReturnSuccess_wszystkWyd() throws Exception {
//        String expected = new String("[]");
        String expected = new String("[{\"id\":3,\"rok\":2015,\"numer\":1,\"isbn\":\"978-83-777-9221-6\"," +
                "\"oprawa\":\"TWARDA\",\"cena\":49.9,\"wydawnictwo\":\"Znak\",\"czydostepne\":true,\"tlumacz\":[]}," +
                "{\"id\":4,\"rok\":2019,\"numer\":null,\"isbn\":\"978-83-280-6779-0\",\"oprawa\":\"MIEKKA\"," +
                "\"cena\":24.99,\"wydawnictwo\":\"Wilga\",\"czydostepne\":true,\"tlumacz\":[]}]");
        MockHttpServletRequestBuilder getRequestBuilder = get("/ksieg/wydania");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }
}
