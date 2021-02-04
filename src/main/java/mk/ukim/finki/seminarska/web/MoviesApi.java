package mk.ukim.finki.seminarska.web;

import mk.ukim.finki.seminarska.model.*;
import mk.ukim.finki.seminarska.model.DTOs.CardMovie;
import mk.ukim.finki.seminarska.model.DTOs.MoviePerPerson;
import mk.ukim.finki.seminarska.model.DTOs.RequestCreateMovie;
import mk.ukim.finki.seminarska.model.DTOs.SuggestionMovie;
import mk.ukim.finki.seminarska.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/api/movies")
public class MoviesApi {
    private final MovieService movieService;
    private final PersonService personService;
    private final CommentService commentService;
    private final GenreService genreService;
    private final MovieUserService movieuserService;

    public MoviesApi(MovieService movieService, PersonService personService, CommentService commentService, GenreService genreService, MovieUserService movieuserService) {
        this.movieService = movieService;
        this.personService = personService;
        this.commentService = commentService;
        this.genreService = genreService;
        this.movieuserService = movieuserService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie addMovie(@RequestBody RequestCreateMovie movieData)
    {
        List<Person> dirs=convertListIntegersToListElements(movieData.directors);
        List<Person> starring=convertListIntegersToListElements(movieData.stars);

        List<Person> writs=convertListIntegersToListElements(movieData.writers);
        List<Comment> comments=new ArrayList<>();

        List<Genre> genres = new ArrayList<Genre>();
        for (int genreId : movieData.genres){
            genres.add(this.genreService.getGenre(genreId));
        }

        Movie movie=new Movie(movieData.title, movieData.yearOfRelease, movieData.description, movieData.rating, genres, dirs, starring, writs, comments, movieData.country, movieData.imageUrl, movieData.movieLength, movieData.videoUrl, movieData.detailsUrl,movieData.languages);
        return this.movieService.addMovie(movie);
    }


    @GetMapping("/paged")
    public Page<Movie> getMovies(@RequestParam("pageSize") int pageSize,
                              @RequestParam("pageNumber") int pageNumber,
                              @RequestParam(value = "orderBy", required = false, defaultValue = "title") String orderBy,
                              @RequestParam(value = "searchTerm", required = false, defaultValue = "") String searchTerm,
                              @RequestParam(value = "genres", required = false) List<Integer> genres
                          ) {
        List<Genre> genreDatabase = this.genreService.getAllGenres();
        List<Integer> genresOptions = new ArrayList<>();
        genreDatabase.forEach(g -> genresOptions.add(g.getId()));
        genres = ((genres == null) ? genresOptions : genres);
        Page<Movie> Movies = this.movieService.getAllMoviesByPage(genres, PageRequest.of(pageNumber - 1, pageSize, orderBy.equals("title") ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending()), searchTerm);
        return Movies;
    }

    @GetMapping("/all")
    public List<Movie> getMovies() {
       return movieService.getAll();
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        return this.movieService.getMovie(movieId);
    }

    @PatchMapping("{movieId}/edit")
    public Movie editMovie(@PathVariable int movieId, @RequestBody RequestCreateMovie movieData)
    {
        List<Person> dirs=convertListIntegersToListElements(movieData.directors);
        List<Person> starring=convertListIntegersToListElements(movieData.stars);

        List<Person> writs=convertListIntegersToListElements(movieData.writers);
        List<Comment> comments=this.movieService.getMovie(movieId).getComments();

        List<Genre> genres = new ArrayList<Genre>();
        for (int genreId : movieData.genres){
            genres.add(this.genreService.getGenre(genreId));
        }

        return this.movieService.updateMovie(movieId, movieData.title, movieData.yearOfRelease, movieData.description, movieData.rating, genres, dirs, starring, writs, comments, movieData.country, movieData.imageUrl, movieData.movieLength, movieData.videoUrl, movieData.detailsUrl,movieData.languages);
    }

    @PostMapping("/{movieId}/delete")
    public void deleteMovie(@PathVariable int movieId){
        this.movieService.deleteMovie(movieId);
    }

    @PostMapping("/{movieId}/comments/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Comment addComment(@PathVariable("movieId") int movieId,
                              @RequestParam("title") String title,
                              @RequestParam("content") String content,
                              @RequestParam("stars") float stars,
                              @RequestParam("email") String email)
    {
        return this.commentService.addComment(title,content, movieId, stars, email);
    }

    @GetMapping("/{movieId}/comments")
    public List<Comment> getComments(@PathVariable int movieId){
        return this.commentService.getComments(movieId);
    }


    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable int commentId){
        this.commentService.deleteComment(commentId);
    }


    private List<Person> convertListIntegersToListElements(List<Integer> people){
        List<Person>list=new ArrayList<>();
        for (int personId : people) {
            Person director = this.personService.getPerson(personId);
            list.add(director);
        }
        return list;
    }

    @GetMapping("/favorites")
    public Page<Movie> getFavoriteMovies(
                                        @AuthenticationPrincipal String username,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam("pageNumber") int pageNumber){
        return this.movieuserService.getAllFavoriteMoviesByPage(username, PageRequest.of(pageNumber - 1, pageSize));
    }

    @GetMapping("/watched")
    public Page<Movie> getWatchedMovies(
            @AuthenticationPrincipal String username,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("pageNumber") int pageNumber){
        return this.movieuserService.getAllWatchedMoviesByPage(username, PageRequest.of(pageNumber - 1, pageSize));
    }


    @GetMapping("/mostwatched")
    public List<CardMovie> getTrendingMoviesLastMonth(){
        Date date = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
        return this.movieuserService.getMostWatchedMovies(date);
    }

    @GetMapping("/directed/{personId}")
    public List<MoviePerPerson> getAllMoviesDirected(@PathVariable int personId){
        return this.movieService.getAllMoviesDirected(personId);
    }

    @GetMapping("/written/{personId}")
    public List<MoviePerPerson> getAllMoviesWritten(@PathVariable int personId){
        return this.movieService.getAllMoviesWritten(personId);
    }
    @GetMapping("/starred/{personId}")
    public List<MoviePerPerson> getAllMoviesStarred(@PathVariable int personId){
        return this.movieService.getAllMoviesStarred(personId);
    }

    @GetMapping("/{movieId}/suggestions")
    public List<SuggestionMovie> getAllSuggestionMovies(@PathVariable int movieId){
        return this.movieService.getSuggestedMovies(movieId);
    }
}
