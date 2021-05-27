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

import java.sql.Date;
import java.time.LocalDate;

/**
 * Runs the app on the client side
 */
public class RunCarRentalApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws AlreadyExists the already exists
     */
    public static void main(String[] args) throws AlreadyExists {
        EmployeeHandler employeeHandler = new EmployeeHandler();
        BranchHandler branchHandler = new BranchHandler();
        CarHandler carHandler = new CarHandler();
        ReservationHandler reservationHandler = new ReservationHandler();
        LocalDate localDate;
        Application.launch(CarRentalApp.class);


        //TODO fix weird bug with delete employee

        //TODO add proper input validation
        //TODO write unit testing



        //TODO make address show in a normal way in reservation list (toString throws exception :( )
        //TODO make app always full screen
        //TODO make password hidden field in register and edit employee

        //TODO optional : make password sent by email
        //TODO optional : encrypt password in client

        //TODO optional : make every view look nice like registration/home
        //TODO optional : put google icons in every view


    }
}
