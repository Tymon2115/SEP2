package shared.Reservation;

public class Car {
    private int id;
    private String make;
    private String model;
    private String color;
    private String numberPlates;

    public Car(int id, String make, String model, String color, String numberPlates) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.numberPlates = numberPlates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(String numberPlates) {
        this.numberPlates = numberPlates;
    }
}
