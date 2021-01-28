package mk.ukim.finki.seminarska.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public class UserDetails {

    @JsonIgnore
    @Id
    @Column(name = "user_id")
    private long id;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    private String firstName;
    private String lastName;

    @Lob
    private byte[] profilePicture;

    private String description;

    public UserDetails(){

    }
    public UserDetails(String firstName, String lastName, ApplicationUser userToSave) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = "";
        this.profilePicture = null;
        this.user = userToSave;

    }

    public ApplicationUser getUser() {
        return user;
    }

    public long getId() {
        return id;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }
}
