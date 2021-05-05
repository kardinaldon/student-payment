package business;

import dao.StudentOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentOrderService {

    @Autowired
    private StudentOrderRepository studentOrderRepository;

    @Transactional
    public void daoTest () {
        studentOrderRepository.findAll();
    }
}
