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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FamilyControllerTest {

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
        this.mockMvc.perform(post("/family")
                .contentType(contentType)
                .content(json))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void shouldReturnHttp302_whenFamilyFound() throws Exception {
        //given
        Gson gson = new Gson();
        String json = gson.toJson(family);

        //when
        this.mockMvc.perform(post("/family")
                .contentType(contentType)
                .content(json))
                .andDo(print());

        //then
        Integer existingId = 1;
        this.mockMvc.perform(get("/family/" + existingId))
                .andDo(print())
                .andExpect(status().isFound());

    }

    @Test
    public void shouldReturnHttp404_whenFamilyNotFound() throws Exception {
        Integer nonExistingId = 999;
        this.mockMvc.perform(get("/family/" + nonExistingId))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldAddFatherToExistingFamily() throws Exception {
        // given
        Gson gson = new Gson();
        String familyJson = gson.toJson(family);

        this.mockMvc.perform(post("/family")
                .contentType(contentType)
                .content(familyJson))
                .andDo(print());

        //when - then
        String fatherJson = gson.toJson(father);
        this.mockMvc.perform(put("/family/1/father")
                .contentType(contentType)
                .content(fatherJson))
                .andDo(print())
                .andExpect(status().isOk());


    }
}