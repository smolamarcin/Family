package com.smola.controllers;

import com.google.gson.Gson;
import com.smola.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.nio.charset.Charset;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FamilyControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    private Father father;
    private Family family;
    private Child firstChild;
    private Child secondChild;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Before
    public void setUp() {
        father = Father.builder()
                .firstName("Jan")
                .secondName("Kowalski")
                .pesel("92939239")
                .birthDate(BirthDate.of("21.07.1994"))
                .build();
        family = new Family();
        firstChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("232323")
                .sex("male")
                .build();

        secondChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("232323")
                .sex("male")
                .build();
    }

    @Test
    public void shouldReturnAddedObjectInBody() throws Exception {
        //given
        Gson gson = new Gson();
        String json = gson.toJson(family);

        //when - then
        this.mockMvc.perform(post("/createFamily")
                .contentType(contentType)
                .content(json))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }


    @Test
    public void shouldAddFatherToFamily() throws Exception {
        assertTrue(false);
    }

    @Test
    public void shouldAddChildrenToFamily() throws Exception {
        assertTrue(false);
    }
}