package shared.Branch;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Branch implements Serializable {
    private int id;
    private String name;
    private String location;


    public Branch(int id, String name, String location) {
        this.name = name;
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StringProperty locationProperty() {
        return new SimpleStringProperty(location);
    }

    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
