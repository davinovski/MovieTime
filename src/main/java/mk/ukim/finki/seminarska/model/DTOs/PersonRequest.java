package mk.ukim.finki.seminarska.model.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class PersonRequest {
    public String name;
    public String bio;
    public Date dateOfBirth;
    public String placeOfBirth;
    public String imageUrl;
}
