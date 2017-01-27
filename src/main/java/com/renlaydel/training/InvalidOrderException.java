package com.renlaydel.training;

/**
 * Created by renlaydel on 24/01/2017.
 */
public class InvalidOrderException extends Exception {

    public InvalidOrderException() {
    }

    public InvalidOrderException(String message) {
        super(message);
    }
}
