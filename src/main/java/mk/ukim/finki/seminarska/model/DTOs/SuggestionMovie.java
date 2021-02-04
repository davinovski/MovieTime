package mk.ukim.finki.seminarska.model.DTOs;

import lombok.NoArgsConstructor;
import mk.ukim.finki.seminarska.model.Person;

import java.util.List;

@NoArgsConstructor
public class SuggestionMovie implements Comparable<SuggestionMovie> {
    private int id;
    private String name;
    private long sameProps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSameProps() {
        return sameProps;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSameProps(long sameProps) {
        this.sameProps = sameProps;
    }

    public SuggestionMovie(int id, String name, long sameGenres) {
        this.id = id;
        this.name = name;
        this.sameProps = sameGenres;
    }

    @Override
    public int compareTo(SuggestionMovie thatMovie) {
        if(this.sameProps > thatMovie.getSameProps())
            return -1;
        else
            return 1;
    }
}
