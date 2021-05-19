package shared.Branches;

import client.exceptions.DoesNotExist;
import shared.Reservation.Car;
import shared.Reservation.Cars;
import shared.Reservation.Reservation;
import shared.Reservation.Reservations;
import shared.personel.Employee;


import java.io.Serializable;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

public class Branch implements Serializable {
    private int id;
    private String name;
    private String location;
    private Reservations reservations;
    private Cars cars;


    public Branch(String name, String location, Reservations reservations, Cars cars) {
        this.name = name;
        this.location = location;
        this.reservations = reservations;
        this.cars = cars;
    }

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

    public Reservations getReservations() {
        return reservations;
    }

    public Cars getCars() {
        return cars;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }


    public void addReservation(Reservation reservation) throws Exception {
        reservations.addReservation(reservation);
    }

    public void createReservation(String name, String surname, String driversLicence, String address, String creditCardNumber, Car car, Branch branch, Date date) throws Exception {
        //  reservations.addReservation(new Reservation(name, surname, driversLicence, address, creditCardNumber, car, branch, date));
    }

    public void editReservation(Reservation reservation, ArrayList<String> properties) {
        reservations.editReservation(reservation, properties);
    }

    public void deleteReservation(Reservation reservation) {
        try {
            reservations.deleteReservation(reservation);
        } catch (DoesNotExist doesNotExist) {
            doesNotExist.printStackTrace();
        }
    }

    public Reservation getReservation(int id) {
        try {
            return reservations.getReservation(id);
        } catch (DoesNotExist doesNotExist) {
            doesNotExist.printStackTrace();
        }
        return null;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void deleteCar(Car car) {
        cars.remove(car);
    }

    public void editCar(Car car, ArrayList<String> properties) {
        cars.editCar(car, properties);
    }

    public Car getCar(int id) {
        return cars.getCar(id);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", reservations=" + reservations +
                ", cars=" + cars +
                '}';
    }
}
