package az.hamburg.librarymanagement.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {

    private String name;
    private String description;
    private Boolean status;
    private BigDecimal price;
}
