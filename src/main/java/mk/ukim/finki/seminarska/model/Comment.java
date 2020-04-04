package mk.ukim.finki.seminarska.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String content;

    private LocalDateTime createdAd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_id")
    private Movie movieId;

    private float stars;


    public Comment(String title,String content, Movie movieId, float stars) {
        this.title=title;
        this.content = content;
        this.movieId=movieId;
        this.createdAd = LocalDateTime.now();
        this.stars=stars;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedAd() {
        return createdAd;
    }


    public String getContent() {
        return content;
    }

    public float getStars() {
        return stars;
    }
}
