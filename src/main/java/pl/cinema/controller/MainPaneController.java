package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pl.cinema.app.Main;

import java.io.IOException;
import java.net.URL;

public class MainPaneController {
    @FXML
    Stage stage = new Stage();

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

    @FXML
    private Button reservationButton;

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

        priceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(PricePaneController.class.getResource("/fxml/pricePane.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(),660,162);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Cennik");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            }
        });

        repertorieButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.setRoot("repertoirePane");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        reservationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.setRoot("reservationPane");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
