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


    public Comment(String title,String content, Movie movieId) {
        this.title=title;
        this.content = content;
        this.movieId=movieId;
        this.createdAd = LocalDateTime.now();
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

}
