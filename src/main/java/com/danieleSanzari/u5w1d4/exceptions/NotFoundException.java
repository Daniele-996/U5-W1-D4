package com.danieleSanzari.u5w1d4.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long elementId) {
        super("l'elemento con id : " + elementId + " non è stato trovato!");
    }
}
