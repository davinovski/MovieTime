package mk.ukim.finki.seminarska.model.DTOs;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CardMovie {
    private int id;
    private String name;
    private long watchedTimes;
    private double rating;
    private String imageUrl;

    public CardMovie(int id, String name, long watchedTimes, double rating, String imageUrl) {
        this.id = id;
        this.name = name;
        this.watchedTimes = watchedTimes;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWatchedTimes(long watchedTimes) {
        this.watchedTimes = watchedTimes;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public long getWatchedTimes() {
        return watchedTimes;
    }

    public double getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
