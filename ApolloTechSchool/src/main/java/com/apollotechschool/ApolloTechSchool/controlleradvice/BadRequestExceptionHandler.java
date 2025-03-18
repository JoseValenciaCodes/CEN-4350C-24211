package com.apollotechschool.ApolloTechSchool.controlleradvice;

import com.apollotechschool.ApolloTechSchool.exceptions.EcommerceApiException;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityAlreadyExistsException;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.exceptions.IncorrectCredentialsException;
import com.apollotechschool.ApolloTechSchool.payloads.ErrorPayload;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
* When an error happens in the back-end avoid using try/catch blocks to return an error response
* Instead use controller advisors to automatically return errors in case they happen
* This one specializes in returning custom defined Bad Request errors
* */

@RestControllerAdvice
public class BadRequestExceptionHandler extends ResponseEntityExceptionHandler
{
    // Throw Exception when trying to find an entity that could not be found
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorPayload> handleEntityNotFoundExceptions(EntityNotFoundException ex, WebRequest webRequest)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorPayload(
                ex.getMessage(),
                webRequest.getDescription(false)
        ));
    }

    // Throw Exception when trying to add a duplicate
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorPayload> handleEntityAlreadyExistsExceptions(EntityAlreadyExistsException ex, WebRequest webRequest)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorPayload(
                ex.getMessage(),
                webRequest.getDescription(false)
                ));
    }

    // Throw Exception when trying to enter incorrect credentials
    @ExceptionHandler(IncorrectCredentialsException.class)
    public ResponseEntity<ErrorPayload> handleIncorrectCredentialsException(IncorrectCredentialsException ex, WebRequest webRequest)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorPayload(
                ex.getMessage(),
                webRequest.getDescription(false)
                ));
    }

    // Throw Exception for BadCredentialsException
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorPayload> handleBadCredentialsException(BadCredentialsException ex, WebRequest webRequest)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorPayload(
                ex.getMessage(),
                webRequest.getDescription(false)
        ));
    }

    // Throw for invalid JWT tokens
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorPayload> handleIllegalStateExceptions(IllegalStateException ex, WebRequest webRequest)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorPayload(
                ex.getMessage(),
                webRequest.getDescription(false)
        ));
    }

    // Throw Exception when Spring Security Authentication is Denied
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorPayload> handleAccessDeniedExceptions(AccessDeniedException accessDeniedException, WebRequest webRequest)
    {
        ErrorPayload errorPayload = new ErrorPayload(
                accessDeniedException.getMessage(),
                webRequest.getDescription(false)
        );

        return new ResponseEntity<ErrorPayload>(errorPayload, HttpStatus.UNAUTHORIZED);
    }

    // Throw 500 Internal Server Errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorPayload> handleGlobalException(Exception e, WebRequest webRequest)
    {
        ErrorPayload errorPayload = new ErrorPayload(
                e.getMessage(),
                webRequest.getDescription(false)
        );

        e.printStackTrace();

        return new ResponseEntity<ErrorPayload>(errorPayload, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Throw exception on EcommerceApiException
    @ExceptionHandler(EcommerceApiException.class)
    public ResponseEntity<ErrorPayload> handleEcommerceApiException(EcommerceApiException ex, WebRequest webRequest)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorPayload(
                        ex.getMessage(),
                        webRequest.getDescription(false)
                )
        );
    }

    // Case for ValidationErrors
    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
         MethodArgumentNotValidException ex,
         HttpHeaders headers,
         HttpStatusCode statusCode,
         WebRequest request
    )
    {
        Map<String, String> errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
