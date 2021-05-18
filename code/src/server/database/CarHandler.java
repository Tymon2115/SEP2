package server.database;

import client.exceptions.AlreadyExists;
import shared.Reservation.Car;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarHandler {

    public void createCar(String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId) throws AlreadyExists {
        try {

            Statement statement1 = DatabaseConnection.getInstance().getConnection().createStatement();

            //TODO finish statement

            ResultSet result = statement1.executeQuery("SELECT * FROM car WHERE ");



            if (result.next()) {

                Statement statement2 = DatabaseConnection.getInstance().getConnection().createStatement();
                statement2.executeUpdate(
                        " INSERT INTO car (make, model, color, number_plates, fuel_type," +
                                " fuel_consumption, seats, engine, transmission, equipment, description, branch_id) " +
                                "VALUES ('" + make + "', '" + model + "', '" + color + "', '" + numberPlates + "', '" + fuelType + "', '" +
                                fuelConsumption + "', '" + seats + "', '" + engine + "', '" + transmission + "', '" + equipment + "', '" + description + "', '" + branchId + "');");
                statement1.close();
                statement2.close();
            } else {
                statement1.close();
                throw new AlreadyExists("This object already exists in the database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car getCar(int searchId) {


        try {
            int id = 0;
            String make = null;
            String model = null;
            String color = null;
            String numberPlates = null;
            String fuelType = null;
            String fuelConsumption = null;
            String seats = null;
            String engine = null;
            String transmission = null;
            String equipment = null;
            String description = null;
            int branchId = 0;
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * from car WHERE id = '" + searchId + "';");
            while (result.next()) {
                id = result.getInt("id");
                make = result.getString("make");
                model = result.getString("model");
                color = result.getString("color");
                numberPlates = result.getString("number_plates");
                fuelType = result.getString("fuel_type");
                fuelConsumption = result.getString("fuel_consumption");
                seats = result.getString("seats");
                engine = result.getString("engine");
                transmission = result.getString("transmission");
                equipment = result.getString("equipment");
                description = result.getString("description");
                branchId = result.getInt("branch_id");
            }
            statement.close();
            result.close();
            return new Car(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Car> getCars() {
        return null;
    }

}
