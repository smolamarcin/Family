package com.smola.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@Getter
public final class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String pesel;
    private String secondName;
    private String sex;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Family family;

    private Child(){
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(firstName, child.firstName) &&
                Objects.equals(pesel, child.pesel) &&
                Objects.equals(secondName, child.secondName) &&
                Objects.equals(sex, child.sex);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, pesel, secondName, sex);
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", secondName='" + secondName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
