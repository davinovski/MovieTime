package mk.ukim.finki.seminarska.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String bio;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String imageUrl;

    @ManyToMany(mappedBy = "directors", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Movie> moviesDirected;

    @ManyToMany(mappedBy = "writers", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Movie> moviesWritten;

    @ManyToMany(mappedBy = "stars", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Movie> moviesStarred;

    
    public Person(String name, String bio, Date dateOfBirth, String placeOfBirth, String imageUrl) {
        this.name = name;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.imageUrl = imageUrl;
    }
    public Person(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
}
