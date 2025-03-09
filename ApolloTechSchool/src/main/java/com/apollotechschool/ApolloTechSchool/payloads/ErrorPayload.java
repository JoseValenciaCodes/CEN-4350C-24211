package com.apollotechschool.ApolloTechSchool.payloads;

import java.util.Date;

/* ErrorPayload
* Class that represents a JSON payload used for error responses
* */
public class ErrorPayload
{
    private String error;
    private String details;
    private Date timestamp;

    public ErrorPayload(String error, String details) {
        this.error = error;
        this.details = details;
        this.timestamp = new Date();
    }

    public String getError()
    {
        return this.error;
    }

    public String getDetails() {
        return details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
