package mk.ukim.finki.seminarska.model.DTOs;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class MostWatchedMovieKey implements Serializable {

    @Column(name = "movie_id")
    long movieId;

    @Column(name = "user_id")
    long userId;

    public MostWatchedMovieKey(long movieId, long userId) {
        this.movieId = movieId;
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + getMovieId().intValue();
        hash = 31 * hash + getUserId().intValue();
        return hash;
    }

}
