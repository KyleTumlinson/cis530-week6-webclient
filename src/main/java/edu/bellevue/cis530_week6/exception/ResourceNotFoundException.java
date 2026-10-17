package edu.bellevue.cis530_week6.exception;

/*
    Exception to handle when a Post is not found
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
