package mk.ukim.finki.seminarska.model.DTOs;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoviePerPerson {
    private int id;
    private String title;
    private int yearOfRelease;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MoviePerPerson(int id, String title, int yearOfRelease, String imageUrl) {
        this.id = id;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.imageUrl = imageUrl;
    }
}
