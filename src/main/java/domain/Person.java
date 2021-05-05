package domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
public class Person {
    private String surName;
    private String givenName;
    private String patronymic;
    private LocalDate dateOfBirth;
}
