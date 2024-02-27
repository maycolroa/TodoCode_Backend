package com.hackacode.agenciaturistica.controller;

import com.hackacode.agenciaturistica.exception.ErrorDetails;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Tag(name="Controlador de excepciones", description = "Controlador de excepciones, permite manejar y controlar  excepciones")
@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({IdNotFoundException.class})
    public ResponseEntity<ErrorDetails> notFoundExceptions(Exception ex) {

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.NOT_FOUND.value() + " NOT_FOUND");
        errorDetails.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

}
