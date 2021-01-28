package mk.ukim.finki.seminarska.model.DTOs;

import lombok.NoArgsConstructor;
import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.model.Movie;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
public class MostWatchedMovie {

    @EmbeddedId
    MostWatchedMovieKey id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    Movie movie;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    ApplicationUser user;

    @Temporal(TemporalType.DATE)
    Date dateWatched;

    public MostWatchedMovieKey getId() {
        return id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setDateWatched(Date dateWatched) {
        this.dateWatched = dateWatched;
    }

    public Date getDateWatched() {
        return dateWatched;
    }

    public void setMostWatchedMovieKey(MostWatchedMovieKey mostWatchedMovieKey) {
        this.id = mostWatchedMovieKey;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public MostWatchedMovieKey getMostWatchedMovieKey() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public MostWatchedMovie(MostWatchedMovieKey id, Movie movie, ApplicationUser user, Date dateWatched) {
        this.id = id;
        this.movie = movie;
        this.user = user;
        this.dateWatched = dateWatched;
    }
}
