package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.model.DTOs.CardMovie;
import mk.ukim.finki.seminarska.model.DTOs.MostWatchedMovie;
import mk.ukim.finki.seminarska.model.DTOs.MostWatchedMovieKey;
import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.exceptions.InvalidMovieIdException;
import mk.ukim.finki.seminarska.model.exceptions.InvalidUserIdException;
import mk.ukim.finki.seminarska.model.exceptions.InvalidUsernameException;
import mk.ukim.finki.seminarska.repository.ApplicationUserRepository;
import mk.ukim.finki.seminarska.repository.MovieRepository;

import mk.ukim.finki.seminarska.repository.MovieUserRepository;
import mk.ukim.finki.seminarska.service.MovieUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieUserServiceImpl implements MovieUserService {
    private final MovieRepository movieRepository;
    private final ApplicationUserRepository applicationUserRepository;
    private final MovieUserRepository movieUserRepository;

    public MovieUserServiceImpl(MovieRepository movieRepository, ApplicationUserRepository applicationUserRepository, MovieUserRepository movieUserRepository) {
        this.movieRepository = movieRepository;
        this.applicationUserRepository = applicationUserRepository;
        this.movieUserRepository = movieUserRepository;
    }

    @Override
    public boolean AddWatched(String username, int movieId){

        ApplicationUser user = this.applicationUserRepository.findByUsername(username);
        if(user == null)
            throw new InvalidUsernameException();
        Movie movie = this.movieRepository.findById(movieId).orElseThrow(InvalidUserIdException::new);
        MostWatchedMovieKey newKey = new MostWatchedMovieKey(movieId, user.getId());
        if(this.movieUserRepository.findById(newKey).isPresent()) {
            this.movieUserRepository.deleteById(newKey);
            return false;
        }
        else {
            this.movieUserRepository.save(new MostWatchedMovie(newKey, movie, user, new Date()));
            return true;
        }
    }

    @Override
    public List<CardMovie> getMostWatchedMovies(Date startDate) {
        return this.movieUserRepository.getMostWatchedMoviesLastWeek(startDate);
    }

    @Override
    public Page<Movie> getAllFavoriteMoviesByPage(String username, Pageable pageable) {
        ApplicationUser applicationUser = this.applicationUserRepository.findByUsername(username);
        if(applicationUser != null){
            return this.movieRepository.getAllFavoriteMovies(applicationUser.getFavoritesIds(), pageable);
        }
        throw new InvalidMovieIdException();

    }

    @Override
    public Page<Movie> getAllWatchedMoviesByPage(String userId, Pageable pageable) {
        ApplicationUser applicationUser = this.applicationUserRepository.findByUsername(userId);
        if(applicationUser != null) {
            return this.movieRepository.getAllFavoriteMovies(applicationUser.getWatched().stream().map(m -> m.getMovie().getId()).collect(Collectors.toList()), pageable);
        }
        throw new InvalidMovieIdException();
    }


}
