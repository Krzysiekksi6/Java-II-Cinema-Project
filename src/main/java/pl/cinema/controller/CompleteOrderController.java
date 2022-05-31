package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.cinema.app.Main;

import java.sql.SQLException;
import java.util.Arrays;


public class CompleteOrderController {
    @FXML
    Label amountOFTikckets;
    @FXML
    Label seats;
    @FXML
    Label nameOfMovieLabel;
    @FXML
    Label timeStarts;
    @FXML
    TextField phoneNumber;
    @FXML
    Button completeButton;

    String[] seatsArr = new String[ReservationPaneController.howManyTickets];

    public void initialize() {

        completeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (int i = 0; i < seatsArr.length; i++) {
                    try {
                        Main.connect.addReservationToBase(Main.connect.idGeneratorReservation(),
                                ReservationPaneController.dataToReserve.get(0).get(1), "Progress", phoneNumber.getText(), seatsArr[i]);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        amountOFTikckets.setText(String.valueOf(ReservationPaneController.howManyTickets));
        getSeats();
        seats.setText(Arrays.toString(seatsArr));
        nameOfMovieLabel.setText(ReservationPaneController.nameOfMovie);
        timeStarts.setText(ReservationPaneController.dataToReserve.get(0).get(3));

        System.out.println(ReservationPaneController.dataToReserve);
    }

    public void getSeats(){
        for(int i=0;i<ReservationPaneController.howManyTickets;i++){
            seatsArr[i] = ReservationPaneController.dataToReserve.get(i).get(4);
            seatsArr[i] = seatsArr[i] + "," + ReservationPaneController.dataToReserve.get(i).get(5);
        }
    }




}
