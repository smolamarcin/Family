package com.smola.repositories;

import com.smola.FamilyApplication;
import com.smola.model.BirthDate;
import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.repositories.FamilyRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        FamilyApplication.class,})
@ActiveProfiles("test")
public class FamilyRepositoryTest {

    @Autowired
    private FamilyRepository familyRepository;

    @Before
    public void setUp() {
        familyRepository.deleteAll();
    }

    @After
    public void tearDown()  {
        familyRepository.deleteAll();
    }

    @Test
    public void shouldSaveFamilyWithFather() {
        // given
        Father father = Father.builder()
                .firstName("Jan")
                .secondName("Kowalski")
                .pesel("92939239")
                .birthDate(BirthDate.of("21.07.1994"))
                .build();
        Family family = new Family();
        family.addFather(father);
        // when
        familyRepository.save(family);

        // then
        List<Family> all = familyRepository.findAll();
        //TODO: ASK BARTEK
//        assertTrue(all.contains(family));
        assertEquals(familyRepository.findAll().size(),1);
    }

    @Test
    public void shouldSaveFamilyWithChildrens() {
//        TODO:
        // give
        Child firstChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("232323")
                .sex("male")
                .build();

        Child secondChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("232323")
                .sex("male")
                .build();

        Family family = new Family();

        family.addChild(firstChild);
        family.addChild(secondChild);

        // when
        familyRepository.save(family);

        // then
        List<Family> all = familyRepository.findAll();
        assertEquals(all.size(),1);
        //TODO
//        assertTrue(familyRepository.findAll().contains(family));
    }
}