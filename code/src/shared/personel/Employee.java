package shared.personel;

import shared.Branch.Branch;

import java.io.Serializable;

public class Employee implements Serializable{
    private String name;
    private String surname;
    private int id;
    private Branch branch;
    private String username;
    private String password;


    int roleId;
    private String email;

    public Employee(int id, String name, String surname, int roleId, Branch branch, String username, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.branch = branch;
        this.roleId = roleId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Employee(String firstName, String lastName, String username, String password)
    {
        this.name = firstName;
        this.surname = lastName;
        this.username = username;
        this.password = password;
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

    public Branch getBranch() {
        return branch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", branch=" + branch +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
