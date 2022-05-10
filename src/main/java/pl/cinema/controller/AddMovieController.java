package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import pl.cinema.app.Main;

import java.io.IOException;

public class AddMovieController {
    @FXML
    MenuButton typeOfSound;
    @FXML
    MenuItem sub;
    @FXML
    MenuItem lector;
    @FXML
    MenuItem dubbing;
    @FXML
    MenuButton category;
    @FXML
    MenuItem comedy;
    @FXML
    MenuItem drama;
    @FXML
    MenuItem thriller;
    @FXML
    MenuItem horror;
    @FXML
    MenuItem animation;
    @FXML
    MenuItem musical;
    @FXML
    MenuItem family;
    @FXML
    MenuItem action;
    @FXML
    TextField nameOfMovie;
    //tu koncze XD ide grac w lige d-,-b
    @FXML
    TextField chooseDate;
    @FXML
    TextField timeStart;
    @FXML
    TextField howLong;
    @FXML
    TextField timeEnd;
    @FXML
    TextField hall;
    @FXML
    TextField minAge;
    @FXML
    TextField choosePicture;
    @FXML
    Button addBut;

    public void initialize(){

        addBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Main.connect.addMovieToBase();
                System.out.println("eeeeeeeeee");
                }
        });
        family.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("eeeeeeeeee");
                //Main.connect.addMovieToBase();
            }
        });

    }

}
