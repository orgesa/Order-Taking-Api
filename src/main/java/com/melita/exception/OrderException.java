package com.melita.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.melita.interceptor.ErrorType;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "stackTrace", "suppressed" })
public class OrderException extends Exception {

    @JsonProperty("resultCode")
    private final Integer resultCode;
    @JsonProperty("result")
    private final String result;
    @JsonProperty("errorType")
    private final ErrorType errorType;

    public OrderException( Integer resultCode, String result,
                           ErrorType errorType , String message, Throwable cause) {

        super(message, cause, true, false);

        this.resultCode = resultCode;
        this.result = result;
        this.errorType = errorType;
    }

    @Override
    public synchronized Exception fillInStackTrace() {
        return this;
    }


    public Integer getResultCode() {
        return resultCode;
    }

    public String getResult() {
        return result;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

}
