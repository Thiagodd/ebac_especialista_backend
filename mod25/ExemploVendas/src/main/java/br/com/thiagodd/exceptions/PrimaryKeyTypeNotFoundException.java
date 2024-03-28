package main.java.br.com.thiagodd.exceptions;

public class PrimaryKeyTypeNotFoundException extends Exception{

    public PrimaryKeyTypeNotFoundException(String message) {
        this(message, null);
    }

    public PrimaryKeyTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
