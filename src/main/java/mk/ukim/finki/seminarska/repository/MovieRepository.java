package mk.ukim.finki.seminarska.repository;

import mk.ukim.finki.seminarska.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query("select distinct m from Movie m join m.genres g where g.id in :list")
    Page<Movie> getAllLists(List<Integer> list, Pageable pageable);

}
