package shared.Branch;

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

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
