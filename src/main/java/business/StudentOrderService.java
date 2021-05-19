package business;

import dao.StreetRepository;
import dao.StudentOrderRepository;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(StudentOrderService.class);

    @Autowired
    private StudentOrderRepository studentOrderRepository;

    @Autowired
    private StreetRepository streetRepository;

    @Transactional
    public void testSave () {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setHusband(buildPerson(false));
        studentOrder.setWife(buildPerson(true));
        studentOrderRepository.save(studentOrder);
    }

    @Transactional
    public void testGet () {
        List<StudentOrder> studentOrderRepositoryAll = studentOrderRepository.findAll();
        for(StudentOrder studentOrder : studentOrderRepositoryAll) {
            LOG.info(studentOrder.toString());
        }

    }

    private Adult buildPerson (boolean wife) {
        Adult adult = new Adult();
        adult.setDateOfBirth(LocalDate.now());
        Address address = new Address();
        address.setApartment("342");
        address.setBuilding("45");
        address.setExtension("G");
        address.setPostCode("1232312");
        adult.setAddress(address);
        Street street = streetRepository.getOne(1L);
        address.setStreet(street);
        if(wife){
            adult.setGivenName("Petrova");
            adult.setSurName("Irina");
            adult.setPatronymic("Ivanovna");
            adult.setPassportNumber("W_PASS_N");
            adult.setPassportSeria("W_PASS_S");
            adult.setIssueDate(LocalDate.of(1987,02,05));
        }
        else {
            adult.setGivenName("Ivanov");
            adult.setSurName("Sergey");
            adult.setPatronymic("Ivanovich");
            adult.setPassportNumber("H_PASS_N");
            adult.setPassportSeria("H_PASS_S");
            adult.setIssueDate(LocalDate.of(1985,05,20));
        }
        return adult;
    }
}
