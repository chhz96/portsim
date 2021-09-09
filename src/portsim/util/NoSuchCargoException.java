package portsim.util;

public class NoSuchCargoException extends Exception{
    public NoSuchCargoException() {
        super();
    }

    public NoSuchCargoException(String message) {
        super(message);
    }
}
