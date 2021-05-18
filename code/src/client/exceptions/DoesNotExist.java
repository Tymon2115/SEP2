package client.exceptions;

public class DoesNotExist extends Exception{
    public DoesNotExist (String error){
        super(error);
    }
}
