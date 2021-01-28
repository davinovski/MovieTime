package mk.ukim.finki.seminarska.model.DTOs;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String username;
}
