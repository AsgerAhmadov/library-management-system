package az.hamburg.librarymanagement.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {

    private String email;
    private String password;
    private String username;
    private String pin;

}