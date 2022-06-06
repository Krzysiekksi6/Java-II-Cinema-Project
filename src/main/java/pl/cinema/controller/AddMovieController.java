package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import pl.cinema.app.Main;

import java.io.File;
import java.io.IOException;

/**
 * Klasa kontrolera wspomagajaca dodawanie filmu do bazy danych
 */
public class AddMovieController {
    @FXML
    Button loadImage;
    @FXML
    AnchorPane ar;
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
    @FXML
    DatePicker chooseDate;

    public void initialize(){
        /**
         * Przycisk od doadania filmu
         */
        addBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String date = String.valueOf(chooseDate.getValue());
                date.replace("/","-");
                try{
                Main.connect.addMovieToBase(Main.connect.idGenerator(),nameOfMovie.getText(),category.getText(),timeStart.getText(),howLong.getText(),timeEnd.getText(),hall.getText(),minAge.getText(),choosePicture.getText(),typeOfSound.getText(),date);
                }catch (Exception e){
                    System.out.println("Nie dziala");
                }
                }
        });
        loadImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getTheUserFilePath();
            }
        });

        lector.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                typeOfSound.setText(lector.getText());
            }
        });

        dubbing.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                typeOfSound.setText(dubbing.getText());
            }
        });

        comedy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                category.setText(comedy.getText());
            }
        });

        drama.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                category.setText(drama.getText());
            }
        });

        thriller.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                category.setText(thriller.getText());
            }
        });

        horror.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                category.setText(horror.getText());
            }
        });

        animation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                category.setText(animation.getText());
            }
        });

        musical.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                category.setText(musical.getText());
            }
        });

        family.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                category.setText(family.getText());
            }
        });

        action.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                category.setText(action.getText());
            }
        });



    }

    /**
     * Dobór sciezki z plików
     */
    public void getTheUserFilePath() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );

        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(null);//tu tzrba
        choosePicture.setText(file.getPath());

    }

}
