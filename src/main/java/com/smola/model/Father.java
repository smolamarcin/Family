package com.smola.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@Getter
public class Father {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 2, message = "First name should have at least 2 characters")
    private String firstName;
    @NotNull
    @Size(min = 2, message = "Second name should have at least 2 characters")
    private String secondName;

    @NotNull
    @Length(min = 12,max = 12)
    @Pattern(regexp = "[1-9]\\d*")
    private String pesel;

    @NotNull
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
