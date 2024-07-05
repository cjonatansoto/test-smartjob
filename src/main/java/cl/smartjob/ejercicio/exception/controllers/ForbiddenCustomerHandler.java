package cl.smartjob.ejercicio.exception.controllers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ForbiddenCustomerHandler {

    @ExceptionHandler // Invalid Credentials
    public ResponseEntity<ErrorMessage> handleInvalidCredentialsException(
            BadCredentialsException ex) {
        return new ResponseEntity<ErrorMessage>(
                new ErrorMessage(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class ErrorMessage {
        private String error;
    }
}
