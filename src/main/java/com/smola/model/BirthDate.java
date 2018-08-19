package com.smola.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
public class BirthDate {
    @Id
    private String birthdayDate;

    private BirthDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public static BirthDate of(String date){
        return new BirthDate(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate birthDate = (BirthDate) o;
        return Objects.equals(birthdayDate, birthDate.birthdayDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthdayDate);
    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "birthdayDate='" + birthdayDate + '\'' +
                '}';
    }
}
