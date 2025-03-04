package com.apollotechschool.ApolloTechSchool.exceptions;

/* EntityAlreadyExistsException
* Exception to throw when an entity that is not meant to have duplicates exists in the DB
* and the user tries to add a duplicate
* */

public class EntityAlreadyExistsException extends RuntimeException
{
    public EntityAlreadyExistsException(String message)
    {
        super(message);
    }
}
