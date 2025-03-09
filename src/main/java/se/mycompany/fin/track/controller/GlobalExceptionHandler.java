package se.mycompany.fin.track.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import se.mycompany.fin.track.exception.AccessTokenNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessTokenNotFoundException.class)
    public ResponseEntity<?> handleAccessTokenNotFoundException(AccessTokenNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
