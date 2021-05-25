package domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class Adult extends Person {

    private String passportSeria;

    private String passportNumber;

    private LocalDate issueDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private PassportOffice passportOffice;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private University university;

    private String studentNumber;
}
