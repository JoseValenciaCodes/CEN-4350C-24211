package com.apollotechschool.ApolloTechSchool.exceptions;

/*IncorrectCredentials Exception
* Throw when the user enters incorrect credentials
* */

public class IncorrectCredentialsException extends RuntimeException
{
    public IncorrectCredentialsException(String message)
    {
        super(message);
    }
}
