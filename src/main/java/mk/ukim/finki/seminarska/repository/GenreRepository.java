package mk.ukim.finki.seminarska.repository;

import mk.ukim.finki.seminarska.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {

}
