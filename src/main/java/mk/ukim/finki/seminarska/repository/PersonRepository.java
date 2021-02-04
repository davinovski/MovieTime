package mk.ukim.finki.seminarska.repository;

import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query("select distinct p from Person p where lower(p.name) like lower(concat('%',:searchTerm,'%'))")
    Page<Person> peopleByTerm(Pageable pageable, String searchTerm);
}
