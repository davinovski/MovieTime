package mk.ukim.finki.seminarska.model.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class RequestCreateMovie {
    public int movieLength;
    public String imageUrl;
    public String title;
    public String videoUrl;
    public int yearOfRelease;
    public String detailsUrl;
    public String description;
    public List<String> languages;
    public String country;
    public List<Integer> writers;
    public List<Integer> directors;
    public List<Integer> stars;
    public List<Integer> genres;
    public float rating;
}
