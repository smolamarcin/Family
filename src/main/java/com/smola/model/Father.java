package com.smola.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@Getter
public class Father {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String secondName;
    private String pesel;

    @Embedded
    private BirthDate birthDate;

    private Father() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Father father = (Father) o;
        return Objects.equals(firstName, father.firstName) &&
                Objects.equals(secondName, father.secondName) &&
                Objects.equals(pesel, father.pesel) &&
                Objects.equals(birthDate, father.birthDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, secondName, pesel, birthDate);
    }
}
