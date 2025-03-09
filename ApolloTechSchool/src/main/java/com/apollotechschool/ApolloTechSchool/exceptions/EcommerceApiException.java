package com.apollotechschool.ApolloTechSchool.exceptions;

import org.springframework.http.HttpStatus;

public class EcommerceApiException extends RuntimeException
{
    private HttpStatus httpStatus;
    private String message;

    public EcommerceApiException(HttpStatus httpStatus, String message)
    {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus()
    {
        return httpStatus;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

}
