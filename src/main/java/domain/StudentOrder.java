package domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jc_student_order_tmp")
@Data
public class StudentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_order_id")
    private Long studentOrderId;

    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "h_sur_name")),
            @AttributeOverride(name = "givenName", column = @Column(name = "h_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "h_patronymic")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "h_date_of_birth")),
    })
    private Person husband;

    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "w_sur_name")),
            @AttributeOverride(name = "givenName", column = @Column(name = "w_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "w_patronymic")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "w_date_of_birth")),
    })
    private Person wife;

}
