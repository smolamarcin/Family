package com.smola;

import com.smola.model.BirthDate;
import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.smola")
@EnableJpaRepositories("com.smola.repositories")
public class FamilyApplication implements CommandLineRunner{
    @Autowired
    private FamilyRepository familyRepository;
    public static void main(String[] args) {
        SpringApplication.run(FamilyApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        Father father = Father.builder()
//                .firstName("Jan")
//                .secondName("Kowalski")
//                .pesel("92939239111")
//                .birthDate(BirthDate.of("22.07.1994"))
//                .build();
//        Family family = new Family();
//        Child firstChild = Child.builder()
//                .firstName("Kamil")
//                .secondName("Slimak")
//                .pesel("92939239112")
//                .sex("male")
//                .build();
//
//        Child secondChild = Child.builder()
//                .firstName("Karol")
//                .secondName("Slimak")
//                .pesel("92939239113")
//                .sex("male")
//                .build();
//
//        family.addFather(father);
//        family.addChild(firstChild);
//        family.addChild(secondChild);
//
//        //second family
//        Father secondFather = Father.builder()
//                .firstName("Jan")
//                .secondName("Kowalski")
//                .pesel("92939239114")
//                .birthDate(BirthDate.of("21.07.1994"))
//                .build();
//        Family secondFamily = new Family();
//        Child thirdChild = Child.builder()
//                .firstName("Anna")
//                .secondName("Jopek")
//                .pesel("92939239115")
//                .sex("female")
//                .build();
//
//        Child fourthChild = Child.builder()
//                .firstName("Karol")
//                .secondName("Slimak")
//                .pesel("92939239116")
//                .sex("male")
//                .build();
//
//        secondFamily.addFather(secondFather);
//        secondFamily.addChild(thirdChild);
//        secondFamily.addChild(fourthChild);
//
//        familyRepository.save(family);
//        familyRepository.save(secondFamily);
    }
}
