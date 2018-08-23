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
        Father father = Father.builder()
                .firstName("Jan")
                .secondName("Kowalski")
                .pesel("92939239111")
                .birthDate(BirthDate.of("22.07.1994"))
                .build();
        Family family = new Family();
        Child firstChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("92939239112")
                .sex("male")
                .build();

        Child secondChild = Child.builder()
                .firstName("Karol")
                .secondName("Slimak")
                .pesel("92939239113")
                .sex("male")
                .build();

        family.addFather(father);
        family.addChild(firstChild);
        family.addChild(secondChild);


        Father father2 = Father.builder()
                .firstName("Jan")
                .secondName("Kowalski")
                .pesel("92939239111")
                .birthDate(BirthDate.of("22.07.1994"))
                .build();
        Family family2 = new Family();
        Child firstChild2 = Child.builder()
                .firstName("Marcin")
                .secondName("Slimak")
                .pesel("92939239112")
                .sex("male")
                .build();

        Child secondChild2 = Child.builder()
                .firstName("Lukasz")
                .secondName("Slimak")
                .pesel("92939239113")
                .sex("male")
                .build();

        family.addFather(father);
        family.addChild(firstChild);
        family.addChild(secondChild);

        family2.addFather(father2);
        family2.addChild(firstChild2);
        family2.addChild(secondChild2);

        familyRepository.save(family);
        familyRepository.save(family2);
    }
}
