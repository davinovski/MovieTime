package mk.ukim.finki.seminarska.service;

import mk.ukim.finki.seminarska.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PersonService {
    Person getPerson(int personId);
    void deletePerson(int personId);
    Person addPerson(Person person);
    Page<Person> getAllByPage(Pageable pageable, String searchTerm);
    List<Person> getAll();
    Person updatePerson(int personId, String name, String bio, Date date, String placeOfBirth, String imageUrl);
}
