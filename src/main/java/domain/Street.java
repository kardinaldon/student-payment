package domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "jc_street")
@Data
public class Street {

    @Id
    @Column(name = "street_code")
    private long streetCode;

    @Column(name = "street_name")
    private String streetName;
}
