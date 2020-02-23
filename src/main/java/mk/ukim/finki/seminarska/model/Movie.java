package mk.ukim.finki.seminarska.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private int yearOfRelease;
    private String description;
    private float rating;
    @ElementCollection(targetClass=String.class)
    private List<String> genres;
    @ManyToMany
    private List<Person> directors;

    @ManyToMany
    private List<Person> stars;

    @ManyToOne
    private Person writer;

    @OneToMany
    private List<Comment> comments;

    public Movie(){
        directors=new ArrayList<>();
        comments=new ArrayList<>();
        stars=new ArrayList<>();
        genres=new ArrayList<>();
    }

    public Movie(String title, int yearOfRelease, String description, float rating, List<String> genres, List<Person> directors, List<Person> stars, Person writer, List<Comment> comments) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.description = description;
        this.rating = rating;
        this.genres = genres;
        this.directors = directors;
        this.stars = stars;
        this.writer = writer;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    public List<Person> getStars() {
        return stars;
    }

    public void setStars(List<Person> stars) {
        this.stars = stars;
    }

    public Person getWriter() {
        return writer;
    }

    public void setWriter(Person writer) {
        this.writer = writer;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }
}

