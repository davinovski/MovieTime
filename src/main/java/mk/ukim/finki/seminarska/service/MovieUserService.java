package mk.ukim.finki.seminarska.service;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.model.DTOs.CardMovie;
import mk.ukim.finki.seminarska.model.DTOs.MostWatchedMovie;
import mk.ukim.finki.seminarska.model.Genre;
import mk.ukim.finki.seminarska.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface MovieUserService {
    boolean AddWatched(String username, int movieId);
    List<CardMovie> getMostWatchedMovies(Date startDate);
    Page<Movie> getAllFavoriteMoviesByPage(String username, Pageable pageable);
    Page<Movie> getAllWatchedMoviesByPage(String userId, Pageable pageable);
}