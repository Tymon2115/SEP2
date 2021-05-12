package client.model.Reservation;

import client.exceptions.AlreadyExists;
import client.exceptions.DoesNotExist;
import client.model.Branches.Branch;


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

    public void editReservation(Reservation reservation) {
        for (Reservation reservation1 : reservations) {
            if (reservation1.equals(reservation)) {
                //todo create edit method
                reservation.editReservation();
            }
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

    public void createReservation(String name, String surname, int id, Branch branch) {
        //todo find out reservation parameters
        reservations.add(new Reservation());
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
