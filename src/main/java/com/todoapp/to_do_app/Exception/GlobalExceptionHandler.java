package com.todoapp.to_do_app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoTaskFoundException.class)
    public ResponseEntity<String> myNoTaskFoundException(NoTaskFoundException e) {
        String response = e.getMessage();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> myAPIException(APIException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
