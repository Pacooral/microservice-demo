package org.example.userservice.response;

import lombok.Data;

@Data
public class MSresponse<T> {
    private int code;
    private String message;
    private T result;
}
