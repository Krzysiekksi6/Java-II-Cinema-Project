package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.cinema.app.CreateTicket;
import pl.cinema.app.Main;
import pl.cinema.app.SendEmail;
import pl.cinema.model.Customer;
import pl.cinema.model.Ticket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Klasa kontrolera dopelnienia zamowienia biletu na seans
 */
public class CompleteOrderController {
    @FXML
    Button wroc;
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
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField emailAddrees;

    final int AGE = 20;
    String[] seatsArr = new String[ReservationPaneController.howManyTickets];




    public void initialize() {
        CreateTicket createTicket = new CreateTicket();
        Customer customer = new Customer();
        /**
         * Przycisk do zkompletowania zamówienia
         */
        wroc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.setRoot("reservationPane");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
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
                // Krzysiek zmiany --------------------
                //TODO Zabezpieczenie przed pustym TextField
                customer.setFirstName(firstNameTextField.getText());
                customer.setLastName(lastNameTextField.getText());
                customer.setEmail(emailAddrees.getText());
                //SendEmail sendEmail = new SendEmail();
                //sendEmail.sendEmail(emailAddrees.getText());
                Customer customer1 = new Customer(firstNameTextField.getText(),lastNameTextField.getText(),AGE,emailAddrees.getText());
                Ticket ticket = new Ticket("0129263845",customer1,26);
                ReservationPaneController.dataToReserve.clear();
                try {
                    createTicket.makeTicket(nameOfMovieLabel.getText(), timeStarts.getText(),customer);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    Main.setRoot("reservationPane");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            // -------------------------------------------------------------------
        });

        amountOFTikckets.setText(String.valueOf(ReservationPaneController.howManyTickets));
        getSeats();
        seats.setText(Arrays.toString(seatsArr));
        nameOfMovieLabel.setText(ReservationPaneController.nameOfMovie);
        timeStarts.setText(ReservationPaneController.dataToReserve.get(0).get(3));

        System.out.println(ReservationPaneController.dataToReserve);
    }

    /**
     * Metoda pobierajaca wybrane miejsce
     */
    public void getSeats(){
        for(int i=0;i<ReservationPaneController.howManyTickets;i++){
            seatsArr[i] = ReservationPaneController.dataToReserve.get(i).get(4);
            seatsArr[i] = seatsArr[i] + "," + ReservationPaneController.dataToReserve.get(i).get(5);
        }
    }




}
