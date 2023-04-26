package ma.codipster.productservice.exception.handlers;

import ma.codipster.productservice.dto.exception.ExceptionError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionError> handleException(Exception e){
        return ResponseEntity.badRequest().body(new ExceptionError(e.getMessage(), HttpStatus.BAD_REQUEST.toString()));
    }

}
