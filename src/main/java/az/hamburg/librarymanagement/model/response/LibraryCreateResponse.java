package az.hamburg.librarymanagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCreateResponse {
    private Long id;
    private String name;
    private String address;
}
