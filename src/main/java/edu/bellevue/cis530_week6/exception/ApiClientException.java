package edu.bellevue.cis530_week6.exception;

public class ApiClientException extends RuntimeException {
    public ApiClientException(String message) {
        super(message);
    }
}
