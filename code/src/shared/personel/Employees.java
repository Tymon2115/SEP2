package shared.personel;

import client.exceptions.AlreadyExists;
import client.exceptions.DoesNotExist;
import shared.Branches.Branch;
import shared.Branches.Branches;

import java.util.ArrayList;
import java.util.List;

//todo one list

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

    public void editEmployee(Employee employee, ArrayList<String> properties) {
        for (Employee employee1 : employees) {
            if (employee1.equals(employee)) {
                for (String property : properties) {
                    whatToEdit(property, employee1);
                }
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

    private void whatToEdit(String property, Employee employee) {
        String name = property.split(",")[0];
        String value = property.split(",")[1];
        switch (name) {
            case "name":
                employee.setName(value);
                break;
            case "surname":
                employee.setSurname(value);
                break;
            case "branch":
                try {
                    employee.setBranch(Branches.getInstance().getBranch(value));
                } catch (DoesNotExist doesNotExist) {
                    doesNotExist.printStackTrace();
                }
                break;

        }
    }



}
