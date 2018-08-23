package com.smola.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Embeddable
public class BirthDate {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    @PastOrPresent
    private LocalDate date;

    private BirthDate(LocalDate date) {
        this.date = date;
    }

    public static BirthDate of(String dateToParse) {
        LocalDate localDate = LocalDate.parse(dateToParse, dateTimeFormatter);
        return new BirthDate(localDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate birthDate = (BirthDate) o;
        return Objects.equals(date, birthDate.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date);
    }
}
