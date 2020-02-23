package mk.ukim.finki.seminarska.service;

import mk.ukim.finki.seminarska.model.Person;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface PersonService {
    Person getPerson(int personId);
    void deletePerson(int personId);
    Person addPerson(Person person);
    List<Person> getAll();
    Person updatePerson(int personId, String name, String bio, Date date, String placeOfBirth);
    Page<Person> getPeopleByPage(int page, int size);
}
