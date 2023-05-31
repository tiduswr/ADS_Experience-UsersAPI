package com.userscontrol.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidations(MethodArgumentNotValidException ex){
        List<String> errors = new ArrayList<>();
        for(FieldError f : ex.getFieldErrors()){
            errors.add(f.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }

}
