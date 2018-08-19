package com.smola.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@Getter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String pesel;
    private String secondName;
    private String sex;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "family_id")
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
        return Objects.equals(id, child.id) &&
                Objects.equals(firstName, child.firstName) &&
                Objects.equals(pesel, child.pesel) &&
                Objects.equals(secondName, child.secondName) &&
                Objects.equals(sex, child.sex) &&
                Objects.equals(family, child.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, pesel, secondName, sex, family);
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", secondName='" + secondName + '\'' +
                ", sex='" + sex + '\'' +
                ", family=" + family +
                '}';
    }
}