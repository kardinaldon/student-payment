package domain;

import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@Embeddable
public class Address {
    private String postCode;
    private String building;
    private String extension;
    private String apartment;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Street street;
}
