package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.Genre;
import mk.ukim.finki.seminarska.model.exceptions.InvalidMovieIdException;
import mk.ukim.finki.seminarska.repository.GenreRepository;
import mk.ukim.finki.seminarska.service.GenreService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre getGenre(int genreId) {
        return this.genreRepository.findById(genreId).orElseThrow(InvalidMovieIdException::new);
    }

    @Override
    public List<Genre> getAllGenres() {
        return this.genreRepository.findAll(Sort.by("name"));
    }
}
