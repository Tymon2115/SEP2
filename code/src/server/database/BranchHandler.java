package server.database;

import shared.Branches.Branch;
import shared.Reservation.Cars;
import shared.Reservation.Reservations;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BranchHandler {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();


    public void createBranch(String name, String location) {
        try {
            Statement statement = connection.createStatement();
         statement.executeUpdate("INSERT INTO 'branch' (name, location) VALUES ('" + name + "','" + location + "');" );

            statement.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    public Branch getBranch(int searchId) {
        try {
            Statement statement = connection.createStatement();


            ResultSet result = statement.executeQuery("SELECT * FROM branch WHERE id = '" + searchId + "' ; ");
            int id = 0;
            String name = null;
            String location = null;

            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                location = result.getString("location");
            }
            statement.close();
            result.close();
            Branch branch = new Branch(id, name, location);
            return branch;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }


    public ArrayList<Branch> getBranch(){

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM 'branch'");
            ArrayList<Branch> branches = new ArrayList<Branch>();
            int id = 0;
            String name = "";
            String location = "";
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                location = result.getString("location");
                branches.add(new Branch(id, name, location));
            }
        return branches;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void editBranch(int id, String name, String location) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE branch SET name ='" + name + "', location = '" + location + "';");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteBranch(int id){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM branch where id= '" + id + "';" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
