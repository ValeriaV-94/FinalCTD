package com.integrador.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<String> ProcessErrorResourceNotFound(ResourcesNotFoundException resourceNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atención: Error. " + resourceNotFoundException.getMessage()+ "\n"
                + resourceNotFoundException.getStackTrace());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> ProcessBadRequest(BadRequestException badRequestException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestException.getMessage());
    }
}