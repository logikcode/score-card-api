package com.decagon.scorecardapi.infrastructure.error_handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@RestController
@ControllerAdvice //controller advice because it used for exception handling across multiple controllers
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
//        LocalDate date = new LocalDate
    ExceptionResponse exceptionResponse = new ExceptionResponse( ex.getMessage(), request.getDescription(false), LocalDate.now());
    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException userNotFoundException, WebRequest request){
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(userNotFoundException.getMessage(), request.getDescription(false), LocalDate.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
         ResponseEntity<Object> response = new ResponseEntity<>(new ExceptionResponse(ex.getBindingResult().toString(), "Request Data Validation Failed",
                 LocalDate.now() ), HttpStatus.BAD_REQUEST);

         return response;
         //return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}
