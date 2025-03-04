package com.apollotechschool.ApolloTechSchool.payloads;

/* ErrorPayload
* Class that represents a JSON payload used for error responses
* */
public class ErrorPayload
{
    public String error;

    public ErrorPayload(String error) {
        this.error = error;
    }

    public String getError()
    {
        return this.error;
    }
}
