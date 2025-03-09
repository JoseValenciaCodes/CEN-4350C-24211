package com.apollotechschool.ApolloTechSchool.payloads;

/* MessagePayload
 * Class that represents a JSON payload used for error responses
 * */

public class MessagePayload
{
    private String message;

    public MessagePayload(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
