package domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "jc_student_order")
@Data
public class StudentOrder {

    @Id
    @Column(name = "student_order_id")
    private Long studentOrderId;

}
