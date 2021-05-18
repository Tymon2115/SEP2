package server.database;

import shared.Reservation.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarHandler {

    public void createCar(String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description) {
        try {
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            statement.executeUpdate(
                    " INSERT INTO 'car' (make, model, color, number_plates, fuel_type," +
                            " fuel_consumption, seats, engine, transmission, equipment, description, branch_id) " +
                            "VALUES (" + make + ", " + model + ", " + color + ", " + numberPlates + ", " + fuelType + ", " +
                            fuelConsumption + ", " + seats + ", " + engine + ", " + transmission + ", " + equipment + ", " + description + ");");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car getCar(int searchId) {
        Car car = null;
        try {
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * from 'car' WHERE 'id' = " + searchId + ";");


            while (result.next()){
                int id = result.getInt("id");
                String make = result.getString("make");
                String model = result.getString("model");
                String color = result.getString("color");
                String numberPlates = result.getString("number_plates");
                String fuelType = result.getString("fuel_type");
                String fuelConsumption = result.getString("fuel_consumption");
                String seats = result.getString("seats");
                String engine = result.getString("engine");
                String transmission = result.getString("transmission");
                String equipment = result.getString("equipment");
                String description = result.getString("description");
                car = new Car(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description);
            }
            statement.close();
            result.close();
            return car;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Car> getCars() {
        return null;
    }

}
