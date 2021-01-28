package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.model.DTOs.MostWatchedMovie;
import mk.ukim.finki.seminarska.model.DTOs.MovieFilter;
import mk.ukim.finki.seminarska.model.DTOs.MoviePerPerson;
import mk.ukim.finki.seminarska.model.Genre;
import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.Person;
import mk.ukim.finki.seminarska.model.exceptions.InvalidMovieIdException;
import mk.ukim.finki.seminarska.repository.MovieRepository;
import mk.ukim.finki.seminarska.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAll() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie getMovie(int movieId) {
        return this.movieRepository.findById(movieId).orElseThrow(InvalidMovieIdException::new);
    }

    @Override
    public void deleteMovie(int movieId) {
        this.movieRepository.deleteById(movieId);
    }

    @Override
    public Movie updateMovie(int movieId, String title, int yearOfRelease, String description, double rating, List<Genre> genres, List<Person> dirs, List<Person> starring, List<Person> movieWriters, List<Comment> comments, String country, String imageUrl, int runtime, String videoUrl, String detailsUrl, List<String> languages) {
        Movie movie = this.movieRepository.findById(movieId).orElseThrow(InvalidMovieIdException::new);
        movie.setTitle(title);
        movie.setGenres(genres);
        movie.setComments(comments);
        movie.setDescription(description);
        movie.setDirectors(dirs);
        movie.setRating(rating);
        movie.setStars(starring);
        movie.setWriters(movieWriters);
        movie.setYearOfRelease(yearOfRelease);
        movie.setCountry(country);
        movie.setMovieLength(runtime);
        movie.setImageUrl(imageUrl);
        movie.setVideoUrl(videoUrl);
        movie.setDetailsUrl(detailsUrl);
        movie.setLanguages(languages);
        return this.movieRepository.save(movie);
    }

    @Override
    public Page<Movie> getAllMoviesByPage(List<Integer> genres, Pageable pageable, String searchTerm) {
        return this.movieRepository.getAllMoviesPaged(genres, pageable, searchTerm);
    }

    @Override
    public List<MoviePerPerson> getAllMoviesStarred(int id) {
        return this.movieRepository.getAllStarredMovies(id);
    }

    @Override
    public List<MoviePerPerson> getAllMoviesDirected(int id) {
        return this.movieRepository.getAllDirectedMovies(id);
    }

    @Override
    public List<MoviePerPerson> getAllMoviesWritten(int id) {
        return this.movieRepository.getAllWrittenMovies(id);
    }




}
