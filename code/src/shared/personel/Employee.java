package shared.personel;

import shared.Branches.Branch;

public class Employee {
    private String name;
    private String surname;
    private int id;
    private Branch branch;

    public Employee(String name, String surname, int id, Branch branch) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.branch = branch;
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

    //todo is the part bellow necessary?

    public void createReservation() {

    }

    public void editReservation() {

    }

    public void deleteReservation() {

    }

}
