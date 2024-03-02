package com.hackacode.agenciaturistica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HibernateOperationException extends Exception {

    public HibernateOperationException (String message){super(message);}
}
