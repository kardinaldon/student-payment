package domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class Person {

    private String surName;

    private String givenName;

    private String patronymic;

    private LocalDate dateOfBirth;

    private Address address;
}
