package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pl.cinema.app.Main;

import java.io.IOException;

public class MainPaneController {

    @FXML
    private Button cinemaButton;

    @FXML
    private Label cinemaLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button priceButton;

    @FXML
    private Button repertorieButton;

    public void initialize() {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.setRoot("loginPane");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        cinemaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.setRoot("cinemaDescriptionPane");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
