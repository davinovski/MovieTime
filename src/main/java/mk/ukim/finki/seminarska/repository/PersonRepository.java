package mk.ukim.finki.seminarska.repository;

import mk.ukim.finki.seminarska.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person,Integer> {
}
