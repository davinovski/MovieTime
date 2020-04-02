package mk.ukim.finki.seminarska.service;

import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.model.DTOs.MovieFilter;
import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.Person;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieService {
    Movie addMovie(Movie movie);
    List<Movie> getAll(MovieFilter movieFilter, String sortedBy);
    Movie getMovie(int movieId);
    void deleteMovie(int movieId);
    Movie updateMovie(int movieId,String title,int yearOfRelease,String description,float rating,List<String> genres,List<Person> dirs,List<Person>starring, List<Person> movieWriters,List<Comment> comments, String country, String imageUrl, int runtime, String videoUrl, String DetailsUrl, List<String>languages);
    Page<Movie> getAllMoviesByPage(int page, int size, String sortedBy);
}
