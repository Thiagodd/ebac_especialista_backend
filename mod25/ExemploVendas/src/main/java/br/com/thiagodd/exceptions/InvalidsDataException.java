package main.java.br.com.thiagodd.exceptions;

public class InvalidsDataException extends Exception{

    public InvalidsDataException(String message) {
        this(message, null);
    }

    public InvalidsDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
