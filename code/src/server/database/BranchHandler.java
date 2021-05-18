package server.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BranchHandler {

    private Connection databaseConnection = DatabaseConnection.getInstance().getConnection();
    private Statement statement;

    public Branch createBranch () {


    }

    public Branch getBranch(int id){

    }

    public ArrayList<Branch> getBranch(){

    }

    public Branch editBranch(int id) {

    }

}
