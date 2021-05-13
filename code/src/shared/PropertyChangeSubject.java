package shared;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject {
    void addListener(PropertyChangeListener listener, String name);
}
