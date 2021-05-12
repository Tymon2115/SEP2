package client.exceptions;

public class AlreadyExists extends Exception {
    public AlreadyExists(String errorMessage) {
        super(errorMessage);
    }
}
