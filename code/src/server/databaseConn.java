package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseConn {
    public static void main(String[] args) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/",
                    "postgres", "jd");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        String sql = "SET SCHEMA 'moviecompany';";
        try {
            Statement statement = c.createStatement();
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sql =  "INSERT INTO \"User\" (firstname,lastname,username,email, password) "
                + "VALUES ('Chuj', 'jd', 'chujjd', 'chujjd@gmail.com', 'jdddddddddddd');";
        try {
            Statement statement = c.createStatement();
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
