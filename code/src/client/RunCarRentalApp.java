package client;

import client.core.CarRentalApp;
import client.exceptions.AlreadyExists;
import javafx.application.Application;
import server.database.BranchHandler;
import server.database.EmployeeHandler;
import shared.Branch.Branch;

public class RunCarRentalApp {
    public static void main(String[] args) {
        EmployeeHandler employeeHandler = new EmployeeHandler();
        BranchHandler branchHandler = new BranchHandler();

        Application.launch(CarRentalApp.class);

    }
}
