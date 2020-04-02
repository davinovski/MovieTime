package mk.ukim.finki.seminarska.web;


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
    public Person addPerson(
            @RequestParam("name") String name,
            @RequestParam("bio") String bio,
            @RequestParam("dateOfBirth") String dateOfBirth,
            @RequestParam("placeOfBirth") String placeOfBirth,
            @RequestParam("imageUrl") String imageUrl)
    {
        Date date=new Date();
        Person person=new Person(name,bio,date,placeOfBirth,imageUrl);
        return this.personService.addPerson(person);

    }

    @PutMapping("/{personId}")
    public Person updatePerson(
            @PathVariable("personId") int personId,
            @RequestParam("name") String name,
            @RequestParam("bio") String bio,
            @RequestParam("dateOfBirth") String dateOfBirth,
            @RequestParam("placeOfBirth") String placeOfBirth,
            @RequestParam("imageUrl") String imageUrl)

    {
        Date date=new Date();
        return this.personService.updatePerson(personId,name,bio,date,placeOfBirth, imageUrl);
    }
}
