package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeePaneController {

    @FXML
    Button addMovieButton;

    public void initialize(){
        addMovieButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(AddMovieController.class.getResource("/fxml/addMovie .fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(),470,433);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Add movie");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            }
        });
    }

}
