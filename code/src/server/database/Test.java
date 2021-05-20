package server.database;

import shared.Branch.Branch;
import shared.Reservation.Car;
import shared.personel.Employee;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        BranchHandler branchHandler = new BranchHandler();
        CarHandler carHandler = new CarHandler();
//        branchHandler.createBranch("testBranch", "testLocation");
//        carHandler.createCar("testMake", "testModel", "testColor", "10", "weed", "negative", "0", "big", "negative","good", "none", 7);
        Car car = carHandler.getCar(3);
        Branch branch = branchHandler.getBranch(7);
        EmployeeHandler employeeHandler = new EmployeeHandler();
     //   employeeHandler.createEmployee("Bob", "Marley", 1, branch, "jaraj", "man");
        ArrayList<Employee> employee = employeeHandler.getEmployees();
        System.out.println(car);
        System.out.println(branch);
        System.out.println(employee);

    }
}
