package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.Person;
import mk.ukim.finki.seminarska.model.exceptions.InvalidMovieIdException;
import mk.ukim.finki.seminarska.repository.MovieRepository;
import mk.ukim.finki.seminarska.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public Movie updateMovie(int movieId,String title,int yearOfRelease,String description,float rating,List<String> genres,List<Person> dirs,List<Person>starring, Person movieWriter,List<Comment> comments) {
        Movie movie=this.movieRepository.findById(movieId).orElseThrow(InvalidMovieIdException::new);
        movie.setTitle(title);
        movie.setGenres(genres);
        movie.setComments(comments);
        movie.setDescription(description);
        movie.setDirectors(dirs);
        movie.setRating(rating);
        movie.setStars(starring);
        movie.setWriter(movieWriter);
        movie.setYearOfRelease(yearOfRelease);
        return this.movieRepository.save(movie);
    }

    @Override
    public Page<Movie> getAllMoviesByPage(int page, int size) {
        return this.movieRepository.findAll(PageRequest.of(page,size));
    }
}
