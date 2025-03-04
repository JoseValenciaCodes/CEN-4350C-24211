package com.apollotechschool.ApolloTechSchool.exceptions;

/* EntityNotFoundException
* Throw when data about an entity is requested but it was not found in the DB
* */
public class EntityNotFoundException extends RuntimeException
{
    public EntityNotFoundException(String message)
    {
        super(message);
    }
}
