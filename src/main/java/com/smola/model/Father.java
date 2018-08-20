package com.smola.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@Getter
public class Father {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String secondName;
    private String pesel;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private BirthDate birthDate;

    private Father() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Father father = (Father) o;
        return Objects.equals(id, father.id) &&
                Objects.equals(firstName, father.firstName) &&
                Objects.equals(secondName, father.secondName) &&
                Objects.equals(pesel, father.pesel) &&
                Objects.equals(birthDate, father.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, pesel, birthDate);
    }

    @Override
    public String toString() {
        return "Father{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
