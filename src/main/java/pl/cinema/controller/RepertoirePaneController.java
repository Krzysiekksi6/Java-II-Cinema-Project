package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.cinema.app.Main;
import pl.cinema.app.MoviesRepertoire;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Klasa kontrolera repertuaru filmow
 */
public class RepertoirePaneController {

    @FXML
    private ImageView imgOne;
    @FXML
    private ImageView imgTwo;
    @FXML
    private ImageView imgThree;
    @FXML
    private ImageView imgFour;
    @FXML
    private ImageView imgFive;
    @FXML
    private ImageView imgSix;
    @FXML
    private Button nextButton;
    @FXML
    Label labelOne;
    @FXML
    private Label labelTwo;
    @FXML
    private Label labelThree;
    @FXML
    private Label labelFour;
    @FXML
    private Label labelFive;
    @FXML
    private Label labelSix;

    @FXML
    private Button backButton;
    @FXML
    private Button buttonSiteBack;

    int buttonFlag = 0;
    public MoviesRepertoire moviesRepertoire = new MoviesRepertoire();

    public void initialize() throws SQLException {
        if(buttonFlag >= Main.connect.movies.size())
        {
            buttonSiteBack.setVisible(false);
        }
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.setRoot("mainPane");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonFlag = Main.connect.movies.size();
                setInfo();
                buttonFlag = buttonFlag - moviesRepertoire.flag;
                if(buttonFlag<=6){
                    nextButton.setVisible(false);
                }
                buttonSiteBack.setVisible(true);
            }
        });
        /**
         * Funckja(przycisk) odnajdująca filmy i wstawiania je z
         * zdjęciami
         */
        buttonSiteBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                moviesRepertoire.flag=moviesRepertoire.flag-(moviesRepertoire.flag%6);
                moviesRepertoire.setDynamicSize(Main.connect.movies.size());
                setInfo();
                nextButton.setVisible(true);
                buttonFlag = buttonFlag + moviesRepertoire.flag;
                System.out.println(buttonFlag);
                if(buttonFlag >= Main.connect.movies.size())
                {
                    buttonSiteBack.setVisible(false);
                }

            }
        });
        moviesRepertoire.getTodaysDay();
        moviesRepertoire.currentMovie();
        moviesRepertoire.setDynamicSize(Main.connect.movies.size());
        setInfo();
        System.out.println(Main.connect.movies.size());
    }


    public void setInfo(){

            int i = moviesRepertoire.flag;

            if(moviesRepertoire.flag>=Main.connect.movies.size()){
            }
            else if(moviesRepertoire.getDynamicSize()==1) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1) +','+ Main.connect.movies.get(i).get(3) +','+Main.connect.movies.get(i).get(4).substring(0,5));
                    imgTwo.setImage(null);
                    labelTwo.setText("");
                    imgThree.setImage(null);
                    labelThree.setText("");
                    imgFour.setImage(null);
                    labelFour.setText("");
                    imgFive.setImage(null);
                    labelFive.setText("");
                    imgSix.setImage(null);
                    labelSix.setText("");
                    moviesRepertoire.flag = 1;
                }
            else if(moviesRepertoire.getDynamicSize()==2) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1) +','+ Main.connect.movies.get(i).get(3) +','+Main.connect.movies.get(i).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1) +','+ Main.connect.movies.get(i+1).get(3) +','+Main.connect.movies.get(i+1).get(4).substring(0,5));
                    imgThree.setImage(null);
                    labelThree.setText("");
                    imgFour.setImage(null);
                    labelFour.setText("");
                    imgFive.setImage(null);
                    labelFive.setText("");
                    imgSix.setImage(null);
                    labelSix.setText("");
                    moviesRepertoire.flag = 2;
                }
            else if(moviesRepertoire.getDynamicSize()==3) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1) +','+ Main.connect.movies.get(i).get(3) +','+Main.connect.movies.get(i).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1) +','+ Main.connect.movies.get(i+1).get(3) +','+Main.connect.movies.get(i+1).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+2).get(9));
                    imgThree.setImage(image);
                    labelThree.setText(Main.connect.movies.get(i+2).get(1) +','+ Main.connect.movies.get(i+2).get(3) +','+Main.connect.movies.get(i+2).get(4).substring(0,5));
                    imgFour.setImage(null);
                    labelFour.setText("");
                    imgFive.setImage(null);
                    labelFive.setText("");
                    imgSix.setImage(null);
                    labelSix.setText("");
                    moviesRepertoire.flag = 3;
                }
            else if(moviesRepertoire.getDynamicSize()==4) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1) +','+ Main.connect.movies.get(i).get(3) +','+Main.connect.movies.get(i).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1) +','+ Main.connect.movies.get(i+1).get(3) +','+Main.connect.movies.get(i+1).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+2).get(9));
                    imgThree.setImage(image);
                    labelThree.setText(Main.connect.movies.get(i+2).get(1) +','+ Main.connect.movies.get(i+2).get(3) +','+Main.connect.movies.get(i+2).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+3).get(9));
                    imgFour.setImage(image);
                    labelFour.setText(Main.connect.movies.get(i+3).get(1) +','+ Main.connect.movies.get(i+3).get(3) +','+Main.connect.movies.get(i+3).get(4).substring(0,5));
                    imgFive.setImage(null);
                    labelFive.setText("");
                    imgSix.setImage(null);
                    labelSix.setText("");
                    moviesRepertoire.flag = 4;
                }
            else if(moviesRepertoire.getDynamicSize()==5) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1) +','+ Main.connect.movies.get(i).get(3) +','+Main.connect.movies.get(i).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1) +','+ Main.connect.movies.get(i+1).get(3) +','+Main.connect.movies.get(i+1).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+2).get(9));
                    imgThree.setImage(image);
                    labelThree.setText(Main.connect.movies.get(i+2).get(1) +','+ Main.connect.movies.get(i+2).get(3) +','+Main.connect.movies.get(i+2).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+3).get(9));
                    imgFour.setImage(image);
                    labelFour.setText(Main.connect.movies.get(i+3).get(1) +','+ Main.connect.movies.get(i+3).get(3) +','+Main.connect.movies.get(i+3).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+4).get(9));
                    imgFive.setImage(image);
                    labelFive.setText(Main.connect.movies.get(i+4).get(1) +','+ Main.connect.movies.get(i+4).get(3) +','+Main.connect.movies.get(i+4).get(4).substring(0,5));
                    imgSix.setImage(null);
                    labelSix.setText("");
                    moviesRepertoire.flag = 5;
                }
            else if(moviesRepertoire.getDynamicSize()>=6) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1) +','+ Main.connect.movies.get(i).get(3) +','+Main.connect.movies.get(i).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1) +','+ Main.connect.movies.get(i+1).get(3) +','+Main.connect.movies.get(i+1).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+2).get(9));
                    imgThree.setImage(image);
                    labelThree.setText(Main.connect.movies.get(i+2).get(1) +','+ Main.connect.movies.get(i+2).get(3) +','+Main.connect.movies.get(i+3).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+3).get(9));
                    imgFour.setImage(image);
                    labelFour.setText(Main.connect.movies.get(i+3).get(1) +','+ Main.connect.movies.get(i+3).get(3) +','+Main.connect.movies.get(i+3).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+4).get(9));
                    imgFive.setImage(image);
                    labelFive.setText(Main.connect.movies.get(i+4).get(1) +','+ Main.connect.movies.get(i+4).get(3) +','+Main.connect.movies.get(i+4).get(4).substring(0,5));
                    image = new Image("file:" + Main.connect.movies.get(i+5).get(9));
                    imgSix.setImage(image);
                    labelSix.setText(Main.connect.movies.get(i+5).get(1) +','+ Main.connect.movies.get(i+5).get(3) +','+Main.connect.movies.get(i+5).get(4).substring(0,5));
                    moviesRepertoire.flag = 6;
                    moviesRepertoire.setDynamicSize(moviesRepertoire.getDynamicSize()-moviesRepertoire.flag);
                }
            else {
                moviesRepertoire.flag = 0;
            }
    }
}
