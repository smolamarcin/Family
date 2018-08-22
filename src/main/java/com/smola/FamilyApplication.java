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
                .pesel("92939239")
                .birthDate(BirthDate.of("21.07.1994"))
                .build();
        Family family = new Family();
        Child firstChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("232323")
                .sex("male")
                .build();

        Child secondChild = Child.builder()
                .firstName("Kamil")
                .secondName("Slimak")
                .pesel("232324")
                .sex("male")
                .build();

        family.addFather(father);
        family.addChild(firstChild);
        family.addChild(secondChild);

        familyRepository.save(family);
    }
}
