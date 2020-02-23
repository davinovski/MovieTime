package mk.ukim.finki.seminarska.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;

    private LocalDateTime createdAd;

    private int movieId;

    public Comment(int movieId, String content) {
        this.movieId=movieId;
        this.content = content;
        this.createdAd = LocalDateTime.now();
    }


}
