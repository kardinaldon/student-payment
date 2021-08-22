package dao;

import domain.StudentOrderChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOrderChildRepository extends JpaRepository<StudentOrderChild, Long> {
}
