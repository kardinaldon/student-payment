package domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "jc_university")
public class University {

    @Id
    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "university_name")
    private String universityName;
}
