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

    public void initialize(){

        Main.connect.gettingDataInputData(tableViewPrice,"SELECT * FROM roznosci.cennik;");
    }
}
