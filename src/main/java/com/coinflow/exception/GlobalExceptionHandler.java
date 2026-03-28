package com.coinflow.exception;

import com.coinflow.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {

        ErrorResponse error = new ErrorResponse();
        // Grab the exact message thrown by your service (e.g., "Wallet not found")
        error.setMessage(ex.getMessage());
        // 400 Bad Request is the standard for business logic/validation errors
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

        ErrorResponse error = new ErrorResponse();
        String dynamicMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        error.setMessage(dynamicMessage);
        error.setStatusCode(400);
        error.setTimeStamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }
}