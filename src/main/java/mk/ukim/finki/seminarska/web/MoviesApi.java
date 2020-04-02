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

        Movie movie=new Movie(movieData.title, movieData.year, movieData.description, 0, movieData.genres,dirs,starring,writs,comments, movieData.country, movieData.imageUrl, movieData.runtime, movieData.videoUrl, movieData.detailsUrl,movieData.languages);
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
    /*
    @PatchMapping("/{movieId}")
    public Movie editMovie(
            @PathVariable int movieId,
            @RequestParam("title") String title,
            @RequestParam("yearOfRelease") int yearOfRelease,
            @RequestParam("description") String description,
            @RequestParam("rating") float rating,
            @RequestParam("genre") String[] genres,
            @RequestParam("directors") int[] directors,
            @RequestParam("stars") int[] stars,
            @RequestParam("writer") int[] writers,
            @RequestParam("country") String country,
            @RequestParam("imageUrl") String imageUrl,
            @RequestParam("movieLength") int movieLength,
            @RequestParam("videoUrl") String videoUrl,
            @RequestParam("detailsUrl") String detailsUrl,
            @RequestParam("languages") String[] languages
            )
    {
        List<Person> dirs=convertListIntegersToListElements(directors);
        List<Person>starring=convertListIntegersToListElements(stars);
        List<String> gens = new ArrayList<>(Arrays.asList(genres));
        List<String> langs = new ArrayList<>(Arrays.asList(languages));
        List<Person> writs=convertListIntegersToListElements(writers);
        List<Comment> comments=this.movieService.getMovie(movieId).getComments();
        return this.movieService.updateMovie(movieId,title,yearOfRelease,description,rating,gens,dirs,starring,writs,comments,country,imageUrl,movieLength, videoUrl, detailsUrl, langs);
    }
     */

    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable int movieId){
        this.movieService.deleteMovie(movieId);
    }

    @PostMapping("/{movieId}/comments/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Comment addComment(@PathVariable("movieId") int movieId,
                              @RequestParam("title") String title,
                              @RequestParam("content")  String content)
    {
        return this.commentService.addComment(title,content,movieId);
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
