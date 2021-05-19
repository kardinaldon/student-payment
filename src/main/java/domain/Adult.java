package domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class Adult extends Person {
    private String passportSeria;
    private String passportNumber;
    private LocalDate issueDate;
}
