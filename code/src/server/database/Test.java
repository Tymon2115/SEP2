package server.database;

import shared.Branches.Branch;
import shared.Reservation.Car;

public class Test {
    public static void main(String[] args) {
        BranchHandler branchHandler= new BranchHandler();
        CarHandler carHandler = new CarHandler();
//        branchHandler.createBranch("testBranch", "testLocation");
//        carHandler.createCar("testMake", "testModel", "testColor", "10", "weed", "negative", "0", "big", "negative","good", "none", 7);
        Car car = carHandler.getCar(3);
        Branch branch = branchHandler.getBranch(7);
        System.out.println(car);
        System.out.println(branch);

    }
}
