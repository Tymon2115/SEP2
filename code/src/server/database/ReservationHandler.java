package server.database;

import client.exceptions.AlreadyExists;
import shared.Branch.Branch;
import shared.Reservation.Address;
import shared.Reservation.Car;
import shared.Reservation.Reservation;


import java.sql.*;
import java.util.ArrayList;

public class ReservationHandler {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private final BranchHandler branchHandler = new BranchHandler();
    private final CarHandler carHandler = new CarHandler();


    public void createReservation (String name, String surname, String driversLicence, Address address, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate, double price) throws AlreadyExists {
        try {
            Statement statement1 = connection.createStatement();

            ResultSet result = statement1.executeQuery("SELECT * FROM reservation WHERE name = '" + name + "' AND surname = '" + surname + "' AND drivers_licence = '" + driversLicence + "' AND address_street = '" + address.getStreet()
            + "' AND address_city = '" + address.getCity() + "' AND address_zip = '" + address.getZip() + "' AND address_country = '" + address.getCountry() + "' AND car_id = '" + car.getId() + "' AND start_branch_id = '" + startBranch.getId()
            + "' AND end_branch_id = '" + endBranch.getId() + "' AND start_date = '" + startDate + "' AND end_date = '" + endDate + "' AND price = '" + price + "');");

            if (!result.next()) {
                Statement statement2 = connection.createStatement();
                statement2.executeUpdate("INSERT INTO 'reservation' (name, surname, drivers_licence, address_street, address_city, address_zip, address_country, car_id, start_branch_id, end_branch_id, start_date, end_date, price) " +
                        "VALUES ('" + name + "','" + surname + "','" + driversLicence + "','" + address.getStreet() + "','" + address.getCity() + "', '" + address.getZip() + "', '" + address.getCountry() + "','" + car.getId() + "', '" + startBranch.getId() + "', '" + endBranch.getId() +
                        "', '" + startDate + "','" + endDate + "', '" + price + "');");

                statement1.close();
                statement2.close();
            } else {
                statement1.close();
                throw new AlreadyExists("This object already exists in the database");
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    public Reservation getReservation(int searchId){
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM 'reservation' WHERE id = '" + searchId + "'); ");
            int id = 0;
            String name = "";
            String surname = "";
            String driversLicence = "";
            String addressStreet = "";
            String addressCity = "";
            String addressZip = "";
            String addressCountry = "";
            Car car = null;
            Branch startBranch = null;
            Branch endBranch = null;
            Date startDate = null;
            Date endDate = null;
            double price = 0.0;

            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                driversLicence = result.getString("drivers_licence");
                addressStreet = result.getString("address_street");
                addressCity = result.getString("address_city");
                addressZip = result.getString("address_zip");
                addressCountry = result.getString("address_country");
                car = carHandler.getCar(result.getInt("car_id"));
                startBranch = branchHandler.getBranch(result.getInt("start_branch_id"));
                endBranch = branchHandler.getBranch(result.getInt("end_branch_id"));
                startDate = result.getDate("start_date");
                endDate = result.getDate("end_date");
                price = result.getDouble("price");
            }
            statement.close();
            result.close();
            Reservation reservation = new Reservation(id, name, surname, driversLicence, new Address(addressStreet, addressCity, addressZip, addressCountry), car, startBranch, endBranch, startDate, endDate, price);
            return reservation;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public ArrayList<Reservation> getReservations(){

        try {


            int id = 0;
            String name = "";
            String surname = "";
            String driversLicence = "";
            String addressStreet = "";
            String addressCity = "";
            String addressZip = "";
            String addressCountry = "";
            Car car = null;
            Branch startBranch = null;
            Branch endBranch = null;
            Date startDate = null;
            Date endDate = null;
            double price = 0.0;

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM 'reservation'");
            ArrayList<Reservation> reservations = new ArrayList<Reservation>();


            while (result.next()) {

                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                driversLicence = result.getString("drivers_licence");
                addressStreet = result.getString("address_street");
                addressCity = result.getString("address_city");
                addressZip = result.getString("address_zip");
                addressCountry = result.getString("address_country");
                car = carHandler.getCar(result.getInt("car_id"));
                startBranch = branchHandler.getBranch(result.getInt("start_branch_id"));
                endBranch = branchHandler.getBranch(result.getInt("end_branch_id"));
                startDate = result.getDate("start_date");
                endDate = result.getDate("end_date");
                price = result.getDouble("price");

                reservations.add(new Reservation(id, name, surname, driversLicence, new Address(addressStreet, addressCity, addressZip, addressCountry), car, startBranch, endBranch, startDate, endDate, price));
            }
            return reservations;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void editReservation(int id, String name, String surname, String driversLicence, Address address, Car car, Branch startBranch, Branch endBranch, Date startDate, Date endDate, double price) {


        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE reservation SET name ='" + name + "', surname = '" + surname + "', drivers_licence ='" + driversLicence + "', address_street = '" + address.getStreet() + "', address_city = '" + address.getCity()
            + "', address_zip = '" + address.getZip() + "', address_country = '" + address.getCountry() + "', car_id = + '" + car.getId() + "', start_branch_id = '" + startBranch.getId() + "', end_branch_id = '" + endBranch.getId()
            + "', start_date = '" + startDate + "', end_date = '" + endDate + "', price = '" + price + "' WHERE id = '" + id + "';");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteReservation(int id){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM reservation where id = '" + id + "';" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
