package client;

import client.core.CarRentalApp;
import client.exceptions.AlreadyExists;
import javafx.application.Application;
import server.database.BranchHandler;
import server.database.CarHandler;
import server.database.EmployeeHandler;
import shared.Branch.Branch;

public class RunCarRentalApp {
    public static void main(String[] args) throws AlreadyExists {
        EmployeeHandler employeeHandler = new EmployeeHandler();
        BranchHandler branchHandler = new BranchHandler();
        CarHandler carHandler = new CarHandler();
        //carHandler.createCar("gowno", "dupa", "red", "10", "weed", "0", "0", "none", "none", "none", "no description", 1, 10000);

        Application.launch(CarRentalApp.class);

    }
}
