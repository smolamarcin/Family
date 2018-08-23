package com.smola.service;

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


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FamilyServiceTest {
    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private FamilyService familyService;


    private static Map<String, String> paramas = new HashMap<>();

    private Father firstFather;
    private Father secondFather;
    private Family firstFamily;
    private Family secondFamily;
    private Child firstChild;
    private Child secondChild;
    private Child thirdChild;
    private Child fourthChild;

    @Before
    public void setUp() {
        firstFather = Father.builder()
                .firstName("Jan")
                .secondName("Kowalski")
                .pesel("92939239")
                .birthDate(BirthDate.of("22.07.1994"))
                .build();
        firstFamily = new Family();
        firstChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("232323")
                .sex("male")
                .build();

        secondChild = Child.builder()
                .firstName("Karol")
                .secondName("Slimak")
                .pesel("232324")
                .sex("male")
                .build();

        firstFamily.addFather(firstFather);
        firstFamily.addChild(firstChild);
        firstFamily.addChild(secondChild);

        //second firstFamily
        secondFather = Father.builder()
                .firstName("Jan")
                .secondName("Kowalski")
                .pesel("92939239")
                .birthDate(BirthDate.of("21.07.1994"))
                .build();
        secondFamily = new Family();
        thirdChild = Child.builder()
                .firstName("Anna")
                .secondName("Jopek")
                .pesel("232323")
                .sex("female")
                .build();

        fourthChild = Child.builder()
                .firstName("Karol")
                .secondName("Slimak")
                .pesel("232325")
                .sex("male")
                .build();

        secondFamily.addFather(secondFather);
        secondFamily.addChild(thirdChild);
        secondFamily.addChild(fourthChild);

        familyRepository.save(firstFamily);
        familyRepository.save(secondFamily);
    }

    @After
    public void tearDown() {
        familyRepository.deleteAll();
        paramas.clear();
    }

    @Test
    public void shouldReturnProperFamily_whenFilteringByFirstName() {
        paramas.put("firstName", "Jan");
        Optional<List<Family>> filteredFamily = familyService.findByChildParams(paramas);
        assertFalse(!filteredFamily.isPresent());
        assertEquals(1, filteredFamily.get().size());
        assertEquals(firstFamily, filteredFamily.get());
    }


}