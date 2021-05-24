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




        //TODO add proper input validation

        //TODO write unit testing

        //TODO make app always full screen
        //TODO make password hidden field in register and edit employee


        //TODO optional : encrypt password in client

        //TODO optional : make every view look nice like registration/home
        //TODO optional : put google icons in every view


    }
}
