package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pl.cinema.app.Main;

import java.io.IOException;

public class RepertoirePaneController {

    @FXML
    private Button backButton;

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
