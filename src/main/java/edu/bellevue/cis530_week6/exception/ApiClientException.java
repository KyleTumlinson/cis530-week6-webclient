package edu.bellevue.cis530_week6.exception;

/*
    Exception for errors between the json api and the client
 */
public class ApiClientException extends RuntimeException {
    public ApiClientException(String message) {
        super(message);
    }
}
