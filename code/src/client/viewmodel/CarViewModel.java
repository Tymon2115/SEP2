//package client.viewmodel;
//
//import client.model.Model;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//import shared.Reservation.Car;
//
//public class CarViewModel {
//
//    public StringProperty usernameProperty;
//    private Model model;
//
//    public CarViewModel(Model model) {
//        this.model = model;
//        usernameProperty = new SimpleStringProperty();
//    }
//
//    public StringProperty usernamePropertyProperty() {
//        return usernameProperty;
//    }
//
//    public void addCarView(Car car) {
//        model.createCar(car);
//    }
//
//    public void deleteCarView(Car car) {
//        model.deleteCar(car);
//    }
//
//    public void openEditCarView(Car car) {
//        model.editCar(car);
//    }
//}
