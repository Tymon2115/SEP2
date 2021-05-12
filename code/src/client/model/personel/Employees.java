package client.model.personel;

import client.exceptions.AlreadyExists;
import client.exceptions.DoesNotExist;
import client.model.Branches.Branch;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employees;
    private Branch branch;

    public Employees(Branch branch) {
        this.branch = branch;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) throws Exception {
        if (!employees.contains(employee))
            employees.add(employee);
        else {
            throw new AlreadyExists("The employee already exists");
        }
    }

    public void editEmployee(Employee employee) {
        for (Employee employee1 : employees) {
            if (employee1.equals(employee)) {
                //todo create edit method
                employee.editEmployee();
            }
        }
    }

    public void deleteEmployee(Employee employee) throws DoesNotExist {
        if (employees.contains(employee)) {
            employees.remove(employee);
            System.out.println("successfully removed");
        } else {
            throw new DoesNotExist("Employee does not exist in the branch employee list");
        }
    }

    public void createEmployee(String name, String surname, int id, Branch branch) {
        employees.add(new Employee(name, surname, id, branch));
    }
}
