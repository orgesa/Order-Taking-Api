package com.melita.interceptor;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ErrorType implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    @JsonProperty("errorCode")
    private String errorCode = null;

    @JsonProperty("errorDescription")
    private String errorDescription = null;

    public ErrorType errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
