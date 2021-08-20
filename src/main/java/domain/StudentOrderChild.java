package domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "jc_student_child")
@Data
public class StudentOrderChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_child_id")
    private Long studentOrderChildId;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_order_id")
    private StudentOrder studentOrder;



}
