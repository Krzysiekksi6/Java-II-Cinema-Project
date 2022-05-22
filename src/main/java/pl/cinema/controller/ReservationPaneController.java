package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import pl.cinema.app.Main;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class ReservationPaneController {
    @FXML
    Label lZeroZero;
    @FXML
    Label lZeroOne;
    @FXML
    Label lZeroTwo;
    @FXML
    Label lZeroThree;
    @FXML
    Label lZeroFour;
    @FXML
    Label lZeroFive;
    @FXML
    Label lOneZero;
    @FXML
    Label lOneTwo;
    @FXML
    Label lOneThree;
    @FXML
    Label lOneFour;
    @FXML
    Label lOneFive;
    @FXML
    Label lTwoZero;
    @FXML
    Label lTwoOne;
    @FXML
    Label lTwoThree;
    @FXML
    Label lTwoFour;
    @FXML
    Label lTwoFive;
    @FXML
    Label lThreeZero;
    @FXML
    Label lThreeOne;
    @FXML
    Label lThreeTwo;
    @FXML
    Label lThreeThree;
    @FXML
    Label lThreeFour;
    @FXML
    Label lThreeFive;
    @FXML
    Label lFourZero;
    @FXML
    Label lFourOne;
    @FXML
    Label lFourTwo;
    @FXML
    Label lFourThree;
    @FXML
    Label lFourFour;
    @FXML
    Label lFourFive;
    @FXML
    Label lFiveZero;
    @FXML
    Label lFiveOne;
    @FXML
    Label lFiveTwo;
    @FXML
    Label lFiveThree;
    @FXML
    Label lFiveFour;
    @FXML
    Label lFiveFive;
    @FXML
    Rectangle rZeroZero;
    @FXML
    Rectangle rZeroOne;
    @FXML
    Rectangle rZeroTwo;
    @FXML
    Rectangle rZeroThree;
    @FXML
    Rectangle rZeroFour;
    @FXML
    Rectangle rZeroFive;
    @FXML
    Rectangle rOneZero;
    @FXML
    Rectangle rOneOne;
    @FXML
    Rectangle rOneTwo;
    @FXML
    Rectangle rOneThree;
    @FXML
    Rectangle rOneFour;
    @FXML
    Rectangle rOneFive;
    @FXML
    Rectangle rTwoZero;
    @FXML
    Rectangle rTwoOne;
    @FXML
    Rectangle rTwoTwo;
    @FXML
    Rectangle rTwoThree;
    @FXML
    Rectangle rTwoFour;
    @FXML
    Rectangle rTwoFive;
    @FXML
    Rectangle rThreeZero;
    @FXML
    Rectangle rThreeOne;
    @FXML
    Rectangle rThreeTwo;
    @FXML
    Rectangle rThreeThree;
    @FXML
    Rectangle rThreeFour;
    @FXML
    Rectangle rThreeFive;
    @FXML
    Rectangle rFourZero;
    @FXML
    Rectangle rFourOne;
    @FXML
    Rectangle rFourTwo;
    @FXML
    Rectangle rFourThree;
    @FXML
    Rectangle rFourFour;
    @FXML
    Rectangle rFourFive;
    @FXML
    Rectangle rFiveZero;
    @FXML
    Rectangle rFiveOne;
    @FXML
    Rectangle rFiveTwo;
    @FXML
    Rectangle rFiveThree;
    @FXML
    Rectangle rFiveFour;
    @FXML
    Rectangle rFiveFive;

    @FXML
    private GridPane gridPane;

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
        lZeroZero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setFree(rZeroZero,lZeroZero);
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

    @FXML
    public void setColor(){

    }



    @FXML
    public void test(){
        System.out.println("e");
    }

    @FXML
    public void test2(){
        System.out.println("e");
    }
    @FXML
    public void setFree(Rectangle r,Label l){
        r.setFill(Color.GREEN);
        l.setText("FREE");
    }


}
