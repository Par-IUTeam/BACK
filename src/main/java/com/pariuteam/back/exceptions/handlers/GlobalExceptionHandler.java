package com.pariuteam.back.exceptions.handlers;

import com.pariuteam.back.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> userHandler(ApiErrors errors){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fuck You");
    }
}
