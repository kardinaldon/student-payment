package domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class Child extends Person {

    private String certificateNumber;
    private LocalDate certificateDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private RegisterOffice registerOffice;

}
