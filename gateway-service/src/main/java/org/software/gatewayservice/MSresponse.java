package org.software.gatewayservice;

import lombok.Data;

@Data
public class MSresponse<T> {
    private int code;
    private String message;
    private T result;
}
