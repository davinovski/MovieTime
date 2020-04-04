package mk.ukim.finki.seminarska.web;


import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.model.DTOs.MovieFilter;
import mk.ukim.finki.seminarska.model.DTOs.RequestCreateMovie;
import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.Person;
import mk.ukim.finki.seminarska.service.CommentService;
import mk.ukim.finki.seminarska.service.MovieService;
import mk.ukim.finki.seminarska.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/api/movies")
public class MoviesApi {
    private final MovieService movieService;
    private final PersonService personService;
    private final CommentService commentService;

    public MoviesApi(MovieService movieService, PersonService personService, CommentService commentService) {
        this.movieService = movieService;
        this.personService = personService;
        this.commentService = commentService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie addMovie(@RequestBody RequestCreateMovie movieData)
    {
        List<Person> dirs=convertListIntegersToListElements(movieData.directors);
        List<Person> starring=convertListIntegersToListElements(movieData.stars);

        List<Person> writs=convertListIntegersToListElements(movieData.writers);
        List<Comment> comments=new ArrayList<>();

        Movie movie=new Movie(movieData.title, movieData.yearOfRelease, movieData.description, movieData.rating, movieData.genres, dirs, starring, writs, comments, movieData.country, movieData.imageUrl, movieData.movieLength, movieData.videoUrl, movieData.detailsUrl,movieData.languages);
        return this.movieService.addMovie(movie);
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam("pageNumber") int pageNumber,
                                 @RequestParam("pageSize") int pageSize,
                                 @RequestParam(required=false, defaultValue =" ") String[] genres,
                                 @RequestParam(required=false, defaultValue="title") String orderBy){
        List<String>gens=Arrays.asList(genres);
        MovieFilter movieFilter=new MovieFilter(gens,pageSize,pageNumber);
        return this.movieService.getAll(movieFilter, orderBy);
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        return this.movieService.getMovie(movieId);
    }


    @PatchMapping("/{movieId}")
    public Movie editMovie(@PathVariable int movieId, @RequestBody RequestCreateMovie movieData)
    {
        List<Person> dirs=convertListIntegersToListElements(movieData.directors);
        List<Person> starring=convertListIntegersToListElements(movieData.stars);

        List<Person> writs=convertListIntegersToListElements(movieData.writers);
        List<Comment> comments=this.movieService.getMovie(movieId).getComments();
        return this.movieService.updateMovie(movieId, movieData.title, movieData.yearOfRelease, movieData.description, movieData.rating, movieData.genres,dirs, starring, writs, comments, movieData.country, movieData.imageUrl, movieData.movieLength, movieData.videoUrl, movieData.detailsUrl,movieData.languages);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable int movieId){
        this.movieService.deleteMovie(movieId);
    }

    @PostMapping("/{movieId}/comments/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Comment addComment(@PathVariable("movieId") int movieId,
                              @RequestParam("title") String title,
                              @RequestParam("content") String content,
                              @RequestParam("stars") float stars)
    {
        return this.commentService.addComment(title,content, movieId, stars);
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








}
