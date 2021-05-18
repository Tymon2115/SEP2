package shared.Reservation;

import shared.Branches.Branch;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;
    private Branch brach;
    private Reservation reservation;

    public Cars(Branch brach, Reservation reservation) {
        this.brach = brach;
        this.reservation = reservation;
        cars = new ArrayList<>();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void remove(Car car) {
        cars.remove(car);
    }

    public void editCar(Car car, ArrayList<String> properties) {
        for (Car car1 : cars) {
            if (car.equals(car1)) {
                for (String property : properties)
                    whatToEdit(car, property);
            }
        }
    }

    private void whatToEdit(Car car, String property) {
        String name = property.split(",")[0];
        String value = property.split(",")[1];
        switch (name) {
            case "make":
                car.setMake(value);
                break;
            case "model":
                car.setModel(value);
            case "numberPlates":
                car.setNumberPlates(value);
            case "color":
                car.setColor(value);
        }
    }

    public Car getCar(int id) {
        return cars.get(id);
    }

}
