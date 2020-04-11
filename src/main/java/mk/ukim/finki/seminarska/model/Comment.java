package mk.ukim.finki.seminarska.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_id")
    private Movie movieId;

    private double stars;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "application_user_id")
    private ApplicationUser user;

    public Comment(){

    }

    public Comment(String title,String content, Movie movieId, double stars, ApplicationUser user) {
        this.title=title;
        this.content = content;
        this.movieId=movieId;
        this.createdAt = LocalDateTime.now();
        this.stars=stars;
        this.user=user;
    }

    public int getId() {
        return id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public double getStars() {
        return stars;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }
}
