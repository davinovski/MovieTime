package mk.ukim.finki.seminarska.web;


import mk.ukim.finki.seminarska.model.Comment;
import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.Person;
import mk.ukim.finki.seminarska.service.MovieService;
import mk.ukim.finki.seminarska.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/api/movies")
public class MoviesApi {
    private final MovieService movieService;
    private final PersonService personService;

    public MoviesApi(MovieService movieService, PersonService personService) {
        this.movieService = movieService;
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie addMovie(@RequestParam("title") String title,
                          @RequestParam("yearOfRelease") int yearOfRelease,
                          @RequestParam("description") String description,
                          @RequestParam("rating") float rating,
                          @RequestParam("genres") String[] genres,
                          @RequestParam("directors") int[] directors,
                          @RequestParam("stars") int[] stars,
                          @RequestParam("writer") int[] writers,
                          @RequestParam("comments") String[] comments,
                          @RequestParam("country") String country,
                          @RequestParam("imageUrl") String imageUrl,
                          @RequestParam("movieLength") int movieLength,
                          @RequestParam("videoUrl") String videoUrl,
                          @RequestParam("detailsUrl") String detailsUrl
                          )
    {
        List<Person> dirs=convertArrayToList(directors);
        List<Person>starring=convertArrayToList(stars);

        List<String> gens = new ArrayList<>(Arrays.asList(genres));
        List<Person> writs=convertArrayToList(writers);

        Movie movie=new Movie(title,yearOfRelease,description,rating,gens,dirs,starring,writs,null, country, imageUrl, movieLength, videoUrl, detailsUrl);
        return this.movieService.addMovie(movie);
    }

    @GetMapping
    public List<Movie> getMovies(){
        return this.movieService.getAll();
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        return this.movieService.getMovie(movieId);
    }

    @PatchMapping("/{movieId}")
    public Movie editMovie(
            @PathVariable int movieId,
            @RequestParam("title") String title,
            @RequestParam("yearOfRelease") int yearOfRelease,
            @RequestParam("description") String description,
            @RequestParam("rating") float rating,
            @RequestParam("genres") String[] genres,
            @RequestParam("directors") int[] directors,
            @RequestParam("stars") int[] stars,
            @RequestParam("writer") int[] writers,
            @RequestParam("comments") String[] comments,
            @RequestParam("country") String country,
            @RequestParam("imageUrl") String imageUrl,
            @RequestParam("movieLength") int movieLength,
            @RequestParam("videoUrl") String videoUrl,
            @RequestParam("detailsUrl") String detailsUrl
            )
    {
        List<Person> dirs=convertArrayToList(directors);
        List<Person>starring=convertArrayToList(stars);
        List<String> gens = new ArrayList<>(Arrays.asList(genres));
        List<Person> writs=convertArrayToList(writers);
        return this.movieService.updateMovie(movieId,title,yearOfRelease,description,rating,gens,dirs,starring,writs,null,country,imageUrl,movieLength, videoUrl, detailsUrl);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable int movieId){
        this.movieService.deleteMovie(movieId);
    }



    private List<Person> convertArrayToList(int[] people){
        List<Person>list=new ArrayList<>();
        for (int personId : people) {
            Person director = this.personService.getPerson(personId);
            list.add(director);
        }
        return list;
    }







}
