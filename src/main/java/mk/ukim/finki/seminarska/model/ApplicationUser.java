package mk.ukim.finki.seminarska.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mk.ukim.finki.seminarska.model.DTOs.MostWatchedMovie;

import javax.persistence.*;
import java.util.List;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private boolean admin;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserDetails userDetails;

    //private boolean deactivated;

    /*@JsonIgnore
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Movie> watchedMovies;*/

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<MostWatchedMovie> watched;

    @ElementCollection(targetClass=Integer.class)
    private List<Integer> favoritesIds;



    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin(){
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Integer> getFavoritesIds() {
        return favoritesIds;
    }

    public void setFavoritesIds(List<Integer> favoritesIds) {
        this.favoritesIds = favoritesIds;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<MostWatchedMovie> getWatched() {
        return watched;
    }

    public void setWatched(List<MostWatchedMovie> watched) {
        this.watched = watched;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

}
