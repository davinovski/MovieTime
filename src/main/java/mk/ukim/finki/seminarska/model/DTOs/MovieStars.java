package mk.ukim.finki.seminarska.model.DTOs;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MovieStars {
    private int id;
    private List<Integer> stars;

    public int getId() {
        return id;
    }

    public List<Integer> getStars() {
        return stars;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setStars(List<Integer> stars) {
        this.stars = stars;
    }

    public MovieStars(int id, List<Integer> stars) {
        this.id = id;
        this.stars = stars;
    }
}
