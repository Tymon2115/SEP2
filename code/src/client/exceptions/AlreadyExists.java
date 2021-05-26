package client.exceptions;


import shared.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AlreadyExists extends Exception{

    private PropertyChangeSupport support;

    public AlreadyExists(String errorMessage) {
        super(errorMessage);
    }
}
