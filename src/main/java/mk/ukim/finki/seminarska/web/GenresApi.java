package mk.ukim.finki.seminarska.web;

import mk.ukim.finki.seminarska.model.Genre;
import mk.ukim.finki.seminarska.service.GenreService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/api/genres")
public class GenresApi {
    private final GenreService genreService;

    public GenresApi(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getGenres(){
        return this.genreService.getAllGenres();
    }
}
