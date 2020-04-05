package mk.ukim.finki.seminarska.service;

import mk.ukim.finki.seminarska.model.Genre;

import java.util.List;

public interface GenreService {
    Genre getGenre(int genreId);
    List<Genre> getAllGenres();
}
