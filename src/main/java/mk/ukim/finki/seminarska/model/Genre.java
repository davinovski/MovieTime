package mk.ukim.finki.seminarska.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Movie> movies;

    public Genre(String name, List<Movie> movies){
        this.name=name;
        this.movies=movies;
    }
    public Genre(){

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
