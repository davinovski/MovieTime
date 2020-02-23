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
    private String imageUrl;
    private String country;
    private int movieLength;
    @ElementCollection(targetClass=String.class)
    private List<String> genres;
    @ManyToMany
    private List<Person> directors;

    @ManyToMany
    private List<Person> stars;

    @ManyToMany
    private List<Person> writers;

    @OneToMany
    private List<Comment> comments;

    private String videoUrl;

    private String detailsUrl;

    public Movie(){
        directors=new ArrayList<>();
        comments=new ArrayList<>();
        stars=new ArrayList<>();
        genres=new ArrayList<>();
    }

    public Movie(String title, int yearOfRelease, String description, float rating, List<String> genres, List<Person> directors, List<Person> stars, List<Person> writers, List<Comment> comments, String country, String imageUrl, int movieLength, String videoUrl, String detailsUrl) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.description = description;
        this.rating = rating;
        this.genres = genres;
        this.directors = directors;
        this.stars = stars;
        this.writers = writers;
        this.comments = comments;
        this.country=country;
        this.movieLength=movieLength;
        this.imageUrl=imageUrl;
        this.videoUrl=videoUrl;
        this.detailsUrl=detailsUrl;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
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

    public List<Person> getWriters() {
        return writers;
    }

    public void setWriters(List<Person> writers) {
        this.writers = writers;
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

