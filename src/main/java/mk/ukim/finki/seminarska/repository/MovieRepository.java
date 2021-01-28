package mk.ukim.finki.seminarska.repository;

import mk.ukim.finki.seminarska.model.DTOs.CardMovie;
import mk.ukim.finki.seminarska.model.DTOs.MostWatchedMovie;
import mk.ukim.finki.seminarska.model.DTOs.MoviePerPerson;
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
    @Query("select distinct m from Movie m join m.genres g where g.id in :list and lower(m.title) like lower(concat('%',:searchTerm,'%'))")
    Page<Movie> getAllMoviesPaged(List<Integer> list, Pageable pageable, String searchTerm);
    @Query("select new mk.ukim.finki.seminarska.model.DTOs.MoviePerPerson(m.id, m.title, m.yearOfRelease, m.imageUrl) from Movie m join m.directors d where d.id = :id order by m.title")
    List<MoviePerPerson> getAllDirectedMovies(int id);
    @Query("select new mk.ukim.finki.seminarska.model.DTOs.MoviePerPerson(m.id, m.title, m.yearOfRelease, m.imageUrl) from Movie AS m join m.stars s where s.id = :id order by m.title")
    List<MoviePerPerson> getAllStarredMovies(int id);
    @Query("select new mk.ukim.finki.seminarska.model.DTOs.MoviePerPerson(m.id, m.title, m.yearOfRelease, m.imageUrl) from Movie m join m.writers w where w.id = :id order by m.title")
    List<MoviePerPerson> getAllWrittenMovies(int id);
    @Query("select distinct m FROM Movie m where m.id in :list")
    Page<Movie> getAllFavoriteMovies(List<Integer> list, Pageable pageable);
    @Query("select distinct m FROM Movie m where m.id in :list")
    Page<Movie> getAllWatchedMovies(List<Integer> list, Pageable pageable);
}
