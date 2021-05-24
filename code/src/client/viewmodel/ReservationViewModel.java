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
        model.addListener(this::listenForReservations, "reservations");
        model.getReservations();
        this.viewHandler = viewHandler;
    }

    private void listenForReservations(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            reservations.clear();
            ArrayList<Reservation> receivedReservations = (ArrayList<Reservation>) propertyChangeEvent.getNewValue();
            reservations.addAll(receivedReservations);
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

    public void openEditView(Reservation selectedReservation) {
        viewHandler.openReservationEditView(selectedReservation);
    }

    public void deleteAction (int id) {
        model.deleteReservation(id);
        model.getReservations();
    }
}