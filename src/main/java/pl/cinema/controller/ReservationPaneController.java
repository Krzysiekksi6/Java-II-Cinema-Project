package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import pl.cinema.app.Main;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class ReservationPaneController {
    @FXML
    private Button backButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label dataLabel;

    @FXML
    private Button reservationButton;

    @FXML
    private MenuButton chooseMovie;

    @FXML
    private MenuButton chooseTime;

    /**
     * Zeby nie wywalało Null Pointer Exception trzeba pobierac dane podobnie jak tutaj nizej getDate i nadać metode
     * getDate na onAction w Scene Builder
     * @param event
     */
    public void getDate(ActionEvent event) throws SQLException {
        LocalDate myDate = datePicker.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        dataLabel.setText(myFormattedDate);
        Main.connect.queryMovies("2020-10-12");
        dataLabel.getText();
        System.out.println(Main.connect.movies.get(1));
        menuButtonItems();
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
    public void menuButtonItems(){
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                chooseMovie.setText(((MenuItem)e.getSource()).getText());
                try {
                    Main.connect.queryGetTime(chooseMovie.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        chooseTime.setText(((MenuItem) e.getSource()).getText());
                    }
                };
                for (int i = 0; i < Main.connect.moviesTimeStart.size(); i++) {
                    MenuItem menuItem2 = new MenuItem(Main.connect.moviesTimeStart.get(i));
                    menuItem2.setOnAction(event2);
                    chooseTime.getItems().add(menuItem2);
                }


            }
        };
        for (int i = 0; i < Main.connect.movies.size(); i++) {
            MenuItem menuItem1 = new MenuItem(Main.connect.movies.get(i).get(1));
            menuItem1.setOnAction(event1);
            chooseMovie.getItems().add(menuItem1);
        }

    }

}
