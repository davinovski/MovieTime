package mk.ukim.finki.seminarska.repository;

import mk.ukim.finki.seminarska.model.DTOs.CardMovie;
import mk.ukim.finki.seminarska.model.DTOs.MostWatchedMovie;
import mk.ukim.finki.seminarska.model.DTOs.MostWatchedMovieKey;
import mk.ukim.finki.seminarska.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieUserRepository extends JpaRepository<MostWatchedMovie, MostWatchedMovieKey> {

    @Query("select new mk.ukim.finki.seminarska.model.DTOs.CardMovie(m.movie.id, m.movie.title, count(m.user), m.movie.rating, m.movie.imageUrl)"
            + "FROM MostWatchedMovie AS m where m.dateWatched >= :startDate GROUP BY m.movie.id, m.movie.title, m.movie.rating, m.movie.imageUrl ORDER BY count(m.user) DESC")
    List<CardMovie> getMostWatchedMoviesLastWeek(Date startDate);


}
