package domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String postCode;
    private String building;
    private String extension;
    private String apartment;
}
