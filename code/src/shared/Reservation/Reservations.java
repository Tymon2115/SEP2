package shared.Reservation;

import client.exceptions.AlreadyExists;
import client.exceptions.DoesNotExist;
import shared.Branches.Branch;
import shared.Branches.Branches;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Reservations {
    private List<Reservation> reservations;
    private Branch branch;
    private Car car;

    public Reservations(Branch branch) {
        reservations = new ArrayList<>();
    }

    public Branch getBranch() {
        return branch;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) throws Exception {
        if (!reservations.contains(reservation))
            reservations.add(reservation);
        else {
            throw new AlreadyExists("The reservation already exists");
        }
    }

    public void editReservation(Reservation reservation, ArrayList<String> parameters) {
        for (Reservation reservation1 : reservations) {
            if (reservation1.equals(reservation)) {
                for (String parameter : parameters)
                    whatToEdit(reservation1, parameter);
            }
        }
    }

    private void whatToEdit(Reservation reservation, String parameters) {
        String name = parameters.split(",")[0];
        String value = parameters.split(",")[0];
        switch (name) {
            case "name":
                reservation.setName(value);
                break;
            case "surname":
                reservation.setSurname(value);
                break;
            case "driversLicence":
                reservation.setDriversLicence(value);
                break;
            case "address":
               // reservation.setAddress(value);
                break;
            case "creditCardNumber":
                reservation.setCreditCardNumber(value);
                break;
            case "Car":
                reservation.setCar(branch.getCars().getCar(Integer.parseInt(value)));
                break;
//            case "branch":
//                try {
//                 //   reservation.setBranch(Branches.getInstance().getBranch(value));
//                } catch (DoesNotExist doesNotExist) {
//                    doesNotExist.printStackTrace();
//                }
//                break;
//            case "date":
//                reservation.setDate(new Date(Integer.parseInt(value.split("/")[0]), Integer.parseInt(value.split("/")[1]), Integer.parseInt(value.split("/")[2])));
//                break;

        }

    }

    public void deleteReservation(Reservation reservation) throws DoesNotExist {
        if (reservations.contains(reservation)) {
            reservations.remove(reservation);
            System.out.println("successfully removed");
        } else {
            throw new DoesNotExist("Reservation does not exist in the branch reservation list");
        }
    }

    public void createReservation(String name, String surname, String driversLicence, String address, String creditCardNumber, Car car, Branch branch, Date date) {
      //  reservations.add(new Reservation(name, surname, driversLicence, address, creditCardNumber, car, branch, date));
    }

    public Reservation getReservation(int id) throws DoesNotExist {
        if (reservations.contains(reservations.get(id)))
            return reservations.get(id);
        throw new DoesNotExist("Could not find the reservation in the branch reservation list");
    }

    public Reservation getReservation(Reservation reservation) throws DoesNotExist {
        for (Reservation reservation1 : reservations) {
            if (reservation1.equals(reservation))
                return reservation;
        }
        throw new DoesNotExist("Could not find the reservation in the branch reservation list");
    }

}
