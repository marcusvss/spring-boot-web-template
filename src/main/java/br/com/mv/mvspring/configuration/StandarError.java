package br.com.mv.mvspring.configuration;

import java.util.Date;

public class StandarError {

    private final String httpCode;
    private final String msgError;
    private final Long timestamp;

    public StandarError(String httpCode, String msgError, Long timestamp) {
        this.httpCode = httpCode;
        this.msgError = msgError;
        this.timestamp = timestamp;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public String getMsgError() {
        return msgError;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
