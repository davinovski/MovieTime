package mk.ukim.finki.seminarska.model.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserInTable {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private boolean admin;

    public UserInTable(long id, String username, String firstName, String lastName, boolean admin) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
    }
}
