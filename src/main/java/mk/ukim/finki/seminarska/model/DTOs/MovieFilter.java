package mk.ukim.finki.seminarska.model.DTOs;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;



public class MovieFilter {
    private List<String> genres;
    private int pageNumber=1;
    private int pageSize=12;

    public List<String> getGenres() {
        return genres;
    }

    public MovieFilter(List<String> genres, int pageNumber, int pageSize) {
        System.out.println(genres.toArray().length);
        if(genres.get(0).isEmpty()){
            this.genres = Arrays.asList("action","adventure","animation","biography","comedy","crime","documentary","drama","history","horror","mystery","romance","sci-fi","thriller");
        }
        else{
            this.genres = genres;
        }
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
