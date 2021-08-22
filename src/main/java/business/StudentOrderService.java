package business;

import dao.*;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(StudentOrderService.class);

    @Autowired
    private StudentOrderRepository studentOrderRepository;

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private StudentOrderStatusRepository studentOrderStatusRepository;

    @Autowired
    private PassportOfficeRepository passportOfficeRepository;

    @Autowired
    private RegisterOfficeRepository registerOfficeRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private StudentOrderChildRepository studentOrderChildRepository;

    @Transactional
    public void testSave () {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setHusband(buildPerson(false));
        studentOrder.setWife(buildPerson(true));
        studentOrder.setStudentOrderDate(LocalDateTime.now());
        studentOrder.setStudentOrderStatus(studentOrderStatusRepository.getOne(1L));
        studentOrder.setCertificateNumber("qwaszx13579");
        studentOrder.setRegisterOffice(registerOfficeRepository.getOne(1L));
        studentOrder.setMarriageDate(LocalDate.of(2019,05,15));
        studentOrderRepository.save(studentOrder);

        StudentOrderChild studentOrderChild = buildChild(studentOrder);
        studentOrderChildRepository.save(studentOrderChild);
    }

    @Transactional
    public void testGet () {
        List<StudentOrder> studentOrderRepositoryAll = studentOrderRepository.findAll();
        LOG.info(studentOrderRepositoryAll.get(0).getWife().getGivenName());
        LOG.info(studentOrderRepositoryAll.get(0).getChildren().get(0).getChild().getGivenName());

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
            adult.setPassportOffice(passportOfficeRepository.getOne(1L));
            adult.setIssueDate(LocalDate.of(1987,02,05));
            adult.setStudentNumber("12357");
            adult.setUniversity(universityRepository.getOne(1L));
        }
        else {
            adult.setGivenName("Ivanov");
            adult.setSurName("Sergey");
            adult.setPatronymic("Ivanovich");
            adult.setPassportNumber("H_PASS_N");
            adult.setPassportSeria("H_PASS_S");
            adult.setPassportOffice(passportOfficeRepository.getOne(1L));
            adult.setIssueDate(LocalDate.of(1985,05,20));
            adult.setStudentNumber("92643");
            adult.setUniversity(universityRepository.getOne(1L));
        }
        return adult;
    }

    private StudentOrderChild buildChild (StudentOrder studentOrder) {
        StudentOrderChild studentOrderChild = new StudentOrderChild();
        studentOrderChild.setStudentOrder(studentOrder);

        Child child = new Child();
        child.setDateOfBirth(LocalDate.now());
        child.setGivenName("Ivanov");
        child.setSurName("Egor");
        child.setPatronymic("Sergeevich");
        child.setCertificateDate(LocalDate.now());
        child.setCertificateNumber("BIRTH_N");
        child.setRegisterOffice(registerOfficeRepository.getOne(1L));

        Address address = new Address();
        address.setApartment("342");
        address.setBuilding("45");
        address.setExtension("G");
        address.setPostCode("1232312");
        Street street = streetRepository.getOne(1L);
        address.setStreet(street);
        child.setAddress(address);
        studentOrderChild.setChild(child);
        return studentOrderChild;
    }
}
