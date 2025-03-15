package az.hamburg.librarymanagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateResponse {

    private Long id;
    private String name;
    private String description;
    private Boolean status;
    private BigDecimal price;

}
