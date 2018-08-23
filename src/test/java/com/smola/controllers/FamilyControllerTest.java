package com.smola.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smola.model.*;
import com.smola.repositories.FamilyRepository;
import com.smola.util.RequestParams;
import org.junit.Before;
import org.junit.BeforeClass;
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

    @Autowired
    private FamilyRepository familyRepository;

    private Father father;
    private Family family;
    private Child firstChild;
    private Child secondChild;

    private static ObjectMapper objectMapper = new ObjectMapper();
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @BeforeClass
    public static void setUpObjectMapper() {
        objectMapper.findAndRegisterModules();
    }

    @Before
    public void setUp() {
        father = Father.builder()
                .firstName("Jan")
                .secondName("Kowalski")
                .pesel("92939239231")
                .birthDate(BirthDate.of("21.07.1994"))
                .build();
        family = new Family();
        firstChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("12323232345")
                .sex("male")
                .build();

        secondChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("23232323461")
                .sex("male")
                .build();
    }


    @Test
    public void shouldReturnAddedObjectInBody() throws Exception {
        //given
        String json = objectMapper.writeValueAsString(family);

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
        String familyJson = objectMapper.writeValueAsString(family);

        //when
        this.mockMvc.perform(post("/family")
                .contentType(contentType)
                .content(familyJson))
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
        String familyJson = objectMapper.writeValueAsString(family);

        this.mockMvc.perform(post("/family")
                .contentType(contentType)
                .content(familyJson))
                .andDo(print());

        //when - then
        String fatherJson = objectMapper.writeValueAsString(father);
        this.mockMvc.perform(post("/family/1/father")
                .contentType(contentType)
                .content(fatherJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnBadRequest_WhenTryingToAddFatherWithBadParameters() throws Exception {
        //given
        Father fatherWithBadParameters = Father.builder()
                .firstName("J")
                .secondName("Kowalski")
                .pesel("92939239")
                .birthDate(BirthDate.of("21.07.1994"))
                .build();
        String familyJson = objectMapper.writeValueAsString(family);
        String fatherJson = objectMapper.writeValueAsString(fatherWithBadParameters);

        this.mockMvc.perform(post("/family")
                .contentType(contentType)
                .content(familyJson))
                .andDo(print());

        //when - then
        this.mockMvc.perform(post("/family/1/father")
                .contentType(contentType)
                .content(fatherJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnFamily_whenSearchByParameters() throws Exception {
        //given
        family.addFather(father);
        family.addChild(firstChild);
        family.addChild(secondChild);

        String familyJson = objectMapper.writeValueAsString(family);

        this.mockMvc.perform(post("/family")
                .contentType(contentType)
                .content(familyJson))
                .andDo(print());

        //when - then
        this.mockMvc.perform(get("/family?" + RequestParams.CHILDFIRSTNAME_REQUEST_PARAMETER.toString() + "=Kamil"))
                .andDo(print())
                .andExpect(status().isFound());

    }
}