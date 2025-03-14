package az.hamburg.librarymanagement.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    @Size(min = 5, max = 30, message = "Email should be min 5, max 30 characters long")
    @Schema(example = "example.com")
    private String email;

    @Schema(example = "12345abcd")
    private String password;

    @Schema(example = "orxan12345")
    private  String username;

    @Schema(example = "kk33kk22")
    private String pin;

}