package com.aniket.jobtrack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleJobNotFound(JobNotFoundException ex){
         ErrorResponse er = new ErrorResponse();
         er.setMessage(ex.getMessage());
         er.setStatus(HttpStatus.NOT_FOUND.value());
         er.setTimestamp(LocalDateTime.now());

         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
}
