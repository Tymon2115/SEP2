package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Reservation.Reservation;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class ReservationViewModel {
    private ObservableList<Reservation> reservations;
    private Model model;
    private ViewHandler viewHandler;

    public ReservationViewModel(Model model, ViewHandler viewHandler) {
        reservations = FXCollections.observableArrayList();
        this.model = model;
        model.getReservations();
        this.viewHandler = viewHandler;
        model.addListener(this::listenForReservations, "reservations");
    }

    private void listenForReservations(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            reservations.clear();
            System.out.println("we are in reservation view model");
            ArrayList<Reservation> receivedReservations = (ArrayList<Reservation>) propertyChangeEvent.getNewValue();
            reservations.addAll(receivedReservations);
            System.out.println(reservations);
        });
    }

    public void home() {
        viewHandler.openFrontPageView();
    }

    public ObservableList<Reservation> getReservations() {
        return reservations;
    }

    public void getAddReservationView() {
        viewHandler.openAddReservationView();
    }
}