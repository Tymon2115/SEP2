package shared.personel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Branch.Branch;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String surname;
    private int id;
    private int branchId;
    private String username;
    private String password;
    int roleId;
    private String email;

    public Employee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.branchId = branchId;
        this.roleId = roleId;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getRoleId() {
        return roleId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }


    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    public StringProperty surnameProperty() {
        return new SimpleStringProperty(surname);
    }

    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

    public StringProperty branchIdProperty() {
        return new SimpleStringProperty(String.valueOf(branchId));
    }

    public StringProperty usernameProperty() {
        return new SimpleStringProperty(username);
    }

    public IntegerProperty roleProperty() {
        return new SimpleIntegerProperty(roleId);
    }

    public StringProperty emailProperty() {
        return new SimpleStringProperty(email);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", branch=" + branchId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
