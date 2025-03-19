package az.hamburg.librarymanagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReadResponse {
    private Long id;
    private String email;
    private String password;
    private  String username;
    private String pin;
    private String role;
}
