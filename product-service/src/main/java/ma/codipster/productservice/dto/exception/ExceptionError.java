package ma.codipster.productservice.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ExceptionError {
    private String message;
    private String code;

}
