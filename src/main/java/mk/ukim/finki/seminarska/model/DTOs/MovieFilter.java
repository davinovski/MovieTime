package mk.ukim.finki.seminarska.model.DTOs;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;



public class MovieFilter {
    public List<String> genres;
    public int pageNumber=1;
    public int pageSize=12;
    public String searchTerm;
    public String orderBy;

    public MovieFilter(int pageSize, int pageNumber, String searchTerm, String orderBy, List<String> genres) {
        this.genres = genres;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.searchTerm=searchTerm;
        this.orderBy=orderBy;
    }
}
