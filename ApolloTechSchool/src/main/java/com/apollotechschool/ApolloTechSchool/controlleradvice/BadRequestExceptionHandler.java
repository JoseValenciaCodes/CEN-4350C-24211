package com.apollotechschool.ApolloTechSchool.controlleradvice;

import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.ErrorPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
* When an error happens in the back-end avoid using try/catch blocks to return an error response
* Instead use controller advisors to automatically return errors in case they happen
* This one specializes in returning custom defined Bad Request errors
* */

@RestControllerAdvice
public class BadRequestExceptionHandler
{
    // Throw Exception when trying to find an entity that could not be found
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorPayload> handleUserAlreadyRegisteredExceptions(EntityNotFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorPayload(ex.getMessage()));
    }
}
