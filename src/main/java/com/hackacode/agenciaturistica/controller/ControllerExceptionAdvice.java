package com.hackacode.agenciaturistica.controller;

import com.hackacode.agenciaturistica.exception.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

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


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({HibernateOperationException.class, })
    public ResponseEntity<ErrorDetails> handleHIbernateOperationException(HibernateOperationException ex) {

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value() + " HIBERNATE_ERROR");
        errorDetails.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validException(MethodArgumentNotValidException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errorDetails.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }



    @Operation(
            summary = "Devuelve excepciones generales",
            description = "Captura y devuelve codigo de estado 400 con excepciones generales"
    )
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ClienteExistException.class, EmpleadoExistException.class, TipoServicioExistException.class,
            ServicioExistException.class, TipoServicioExistException.class})
    public ResponseEntity<ErrorDetails> badRequestExceptions(Exception ex) {

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.BAD_REQUEST.value() + " BAD_REQUEST");
        errorDetails.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
