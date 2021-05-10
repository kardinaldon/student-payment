package business;

import dao.StreetRepository;
import dao.StudentOrderRepository;
import domain.Address;
import domain.Person;
import domain.Street;
import domain.StudentOrder;
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
        LOG.info(studentOrderRepositoryAll.get(0).getWife().getGivenName());
    }

    private Person buildPerson (boolean wife) {
        Person person = new Person();
        person.setDateOfBirth(LocalDate.now());
        Address address = new Address();
        address.setApartment("342");
        address.setBuilding("45");
        address.setExtension("G");
        address.setPostCode("1232312");
        person.setAddress(address);
        Street street = streetRepository.getOne(1L);
        address.setStreet(street);
        if(wife){
            person.setGivenName("Petrova");
            person.setSurName("Irina");
            person.setPatronymic("Ivanovna");
        }
        else {
            person.setGivenName("Ivanov");
            person.setSurName("Sergey");
            person.setPatronymic("Ivanovich");
        }
        return person;
    }
}
