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

public class RunCarRentalApp {
    public static void main(String[] args) throws AlreadyExists {
        EmployeeHandler employeeHandler = new EmployeeHandler();
        BranchHandler branchHandler = new BranchHandler();
        CarHandler carHandler = new CarHandler();
        ReservationHandler reservationHandler = new ReservationHandler();
        LocalDate localDate;
//        branchHandler.createBranch("test", "test");
//        employeeHandler.createEmployee("owner", "owner", 1, new Branch(1, "jd", "jd"), "owner", "owner", "d");
        // reservationHandler.createReservation("fuck", "jorn" , "fatfuckJorn", new Address("gelato", "drei drei", "42069", "jamaica"), 1,1, 2, new LocalDate(1,2,3),new LocalDate(1,2,3),200000, "j@hotmail.sk", "420420420");
        Application.launch(CarRentalApp.class);

    }
}
