package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import pl.cinema.app.Connect;
import pl.cinema.app.Main;

import java.io.IOException;

public class PricePaneController {

    @FXML
    private TableView tableViewPrice;

    @FXML
    private Button backButton;

    Connect connect = new Connect();
    public void initialize(){
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                connect.CreateTable();
                try {
                    Main.setRoot("mainPane");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        connect.gettingDataInputData(tableViewPrice,"SELECT * FROM roznosci.cennik;");
    }
}
