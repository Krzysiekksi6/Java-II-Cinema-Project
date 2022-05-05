package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import pl.cinema.app.Main;

import java.io.IOException;
import java.time.LocalDate;

public class ReservationPaneController {
    @FXML
    private Button backButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label dataLabel;

    /**
     * Zeby nie wywalało Null Pointer Exception trzeba pobierac dane podobnie jak tutaj nizej getDate i nadać metode
     * getDate na onAction w Scene Builder
     * @param event
     */
    public void getDate(ActionEvent event) {
        LocalDate myDate = datePicker.getValue();
        dataLabel.setText(myDate.toString());
    }

    public void initialize(){
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.setRoot("mainPane");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
