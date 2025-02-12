package cl.smartjob.ejercicio.exception.controllers;

import cl.smartjob.ejercicio.exception.NotFoundException;
import cl.smartjob.ejercicio.exception.responses.BaseErrorResponse;
import cl.smartjob.ejercicio.exception.responses.ErrorResponse;
import cl.smartjob.ejercicio.exception.responses.ErrorsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestController {

    @ExceptionHandler({NotFoundException.class})
    public BaseErrorResponse handleNotFoundException(RuntimeException exception) {
        return ErrorResponse.builder()
                .error(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleNotValidException(MethodArgumentNotValidException exception) {
        var errors = new ArrayList<String>();
        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
        return ErrorsResponse.builder()
                .errors(errors)
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

}
