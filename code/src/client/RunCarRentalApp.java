package client;

import client.core.CarRentalApp;
import client.exceptions.AlreadyExists;
import client.views.ReservationView.ReservationViewController;
import javafx.application.Application;
import server.database.BranchHandler;
import server.database.CarHandler;
import server.database.EmployeeHandler;
import server.database.ReservationHandler;
import shared.Branch.Branch;
import shared.Reservation.Address;

import java.time.LocalDate;

import java.util.Date;


public class RunCarRentalApp {
    public static void main(String[] args) throws AlreadyExists {
        EmployeeHandler employeeHandler = new EmployeeHandler();
        BranchHandler branchHandler = new BranchHandler();
        CarHandler carHandler = new CarHandler();
        ReservationHandler reservationHandler = new ReservationHandler();
        LocalDate localDate;
        Application.launch(CarRentalApp.class);





        //NOT GUI
        //TODO write javadocs
        //TODO write unit testing
        //GUI
        //TODO make app always full screen
        //TODO make password hidden field in register and edit employee
        //TODO optional : make every view look nice like registration/home
        //TODO optional : put google icons in every view


        // methods to add to diagram :
        // AddEditBranchViewModel : private void listenForBranches(PropertyChangeEvent propertyChangeEvent), private void defaultFields(), private void reload()
        // AddEditCarViewModel : private void listenForCars (PropertyChangeEvent propertyChangeEvent), private void defaultFields(), private void reload()
        // AddEditReservationViewModel : private void listenForReservations (PropertyChangeEvent propertyChangeEvent), private void defaultFields(), private void reload(), public void calculatePrice()
        // RegistrationViewModel : private void listenForEmployees (PropertyChangeEvent propertyChangeEvent), private void reload()
        // RegistrationViewModel : defaultFields from public to private
        // Employee : public String getEmail()
        // Employee : public int getRoleId()


        // fields to add to diagram :
        // AddEditBranchViewModel : private ArrayList<Branch> branches
        // AddEditCarViewModel : private ArrayList<Car> cars
        // AddEditReservationViewModel : private ArrayList<Reservation> reservations, private ArrayList<Car> receivedCars
        // RegisterViewModel : private ArrayList<Employee> employees
        // BranchViewModel : private ArrayList<Employee> employees, private ArrayList<Car> cars, private ArrayList<Reservation> reservations, private StringProperty message
        // CarViewModel : private ArrayList<Reservation> reservations, private StringProperty message;

        // other changes :
        // BranchHandler - createBranch doesnt throw already exists exception
        // EmployeeHandler - createEmployee doesnt throw already exists exception
        // ReservationHandler - createReservation doesnt throw already exists exception
        // CarHandler - createCar doesnt throw already exists exception

    }
}
