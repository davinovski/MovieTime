package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.Person;
import mk.ukim.finki.seminarska.model.exceptions.InvalidPersonIdException;
import mk.ukim.finki.seminarska.repository.PersonRepository;
import mk.ukim.finki.seminarska.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPerson(int personId) {
        return this.personRepository.findById(personId).orElseThrow(InvalidPersonIdException::new);
    }

    @Override
    public void deletePerson(int personId) {
        this.personRepository.deleteById(personId);
    }

    @Override
    public Person addPerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return this.personRepository.findAll();
    }

    @Override
    public Person updatePerson(int personId, String name, String bio, Date date, String placeOfBirth) {
        Person person=this.personRepository.findById(personId).orElseThrow(InvalidPersonIdException::new);
        person.setBio(bio);
        person.setDateOfBirth(date);
        person.setName(name);
        person.setPlaceOfBirth(placeOfBirth);
        return this.personRepository.save(person);
    }

    @Override
    public Page<Person> getPeopleByPage(int page, int size){
        return this.personRepository.findAll(PageRequest.of(page,size));
    }
}