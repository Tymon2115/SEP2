package server.database;


import client.exceptions.AlreadyExists;
import shared.Reservation.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarHandler {

    public void createCar(String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws AlreadyExists {
        try {

            Statement statement1 = DatabaseConnection.getInstance().getConnection().createStatement();

            ResultSet result = statement1.executeQuery("SELECT * FROM car WHERE make = '" + make + "' AND model ='" + model + "' AND color = '" + color + "' AND number_plates = '" + numberPlates + "' AND fuel_type = '" + fuelType + "' AND " +
                    "fuel_consumption = '" + fuelConsumption + "' AND seats = '" + seats + "' AND engine = '" + engine + "' AND transmission = '" + transmission + "' AND equipment = '" + equipment + "' AND description = '" + description
            + "' AND branch_id = '" + branchId + "' AND daily_price = '" + dailyPrice + "';");





            if (!result.next()) {

                Statement statement2 = DatabaseConnection.getInstance().getConnection().createStatement();
                statement2.executeUpdate(
                        " INSERT INTO car (make, model, color, number_plates, fuel_type," +
                                " fuel_consumption, seats, engine, transmission, equipment, description, branch_id, daily_price) " +
                                "VALUES ('" + make + "', '" + model + "', '" + color + "', '" + numberPlates + "', '" + fuelType + "', '" +
                                fuelConsumption + "', '" + seats + "', '" + engine + "', '" + transmission + "', '" + equipment + "', '" + description + "', '" + branchId + "', '" + dailyPrice + "');");
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
            double dailyPrice = 0;
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
                dailyPrice = result.getDouble("daily_price");
            }
            statement.close();
            result.close();
            return new Car(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * from car");
            while (result.next()) {
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
                int branchId = result.getInt("branch_id");
                double dailyPrice = result.getDouble("daily_price");
                cars.add(new Car(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice));
            }
            return cars;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return cars;
        }

    }

    public void editCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) {
        try {
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            statement.executeUpdate("UPDATE car SET make = '" + make + "', model = '" + model + "', color = '" + color + "', number_plates = '" + numberPlates + "', fuel_type = '" + fuelType + "', fuel_consumption = '" + fuelConsumption +
                    "',seats = '" + seats + "', engine = '" + engine + "', transmission = '" + transmission + "', equipment = '" + equipment + "', description = '" + description + "', branch_id = '" + branchId + "', daily_price = '" + dailyPrice +
                    "' WHERE id = '" + id + "';");
            statement.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    public void deleteCar(int id) {
        try {
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            statement.executeUpdate("DELETE FROM car where id = '" + id + "';");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
