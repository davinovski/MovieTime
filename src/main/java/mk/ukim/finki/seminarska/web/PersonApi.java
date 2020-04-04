package mk.ukim.finki.seminarska.web;


import mk.ukim.finki.seminarska.model.DTOs.PersonRequest;
import mk.ukim.finki.seminarska.model.Person;
import mk.ukim.finki.seminarska.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/api/cast")
public class PersonApi {
    private final PersonService personService;

    public PersonApi(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll(){
        return this.personService.getAll();
    }

    @GetMapping("/{personId}")
    public Person getPerson(@PathVariable int personId){
        return this.personService.getPerson(personId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person addPerson(@RequestBody PersonRequest personRequest)
    {
        Person person=new Person(personRequest.name,personRequest.bio,personRequest.dateOfBirth,personRequest.placeOfBirth,personRequest.imageUrl);
        return this.personService.addPerson(person);
    }

    @PutMapping("/{personId}")
    public Person updatePerson(
            @PathVariable("personId") int personId,
            @RequestBody PersonRequest personRequest)

    {
        return this.personService.updatePerson(personId,personRequest.name,personRequest.bio,personRequest.dateOfBirth,personRequest.placeOfBirth,personRequest.imageUrl);
    }
}
