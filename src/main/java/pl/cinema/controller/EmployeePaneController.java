package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.cinema.app.Main;

import java.io.IOException;

/**
 * Klasa kontrolera
 * uprawnienia: Pracownik
 *
 */
public class EmployeePaneController {

    @FXML
    Button addMovieButton;
    @FXML
    Button buttonBck;

    /**
     * Metoda startowa
     */
    public void initialize(){
        buttonBck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.setRoot("mainPane");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        /**
         * Dodawanie filmu do repertuaru znajdujacego sie w bazie danych
         */
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
