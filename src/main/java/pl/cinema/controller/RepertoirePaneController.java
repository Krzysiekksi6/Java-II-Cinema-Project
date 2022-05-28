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

    public MoviesRepertoire moviesRepertoire = new MoviesRepertoire();

    public void initialize() throws SQLException {
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Image image = new Image("file:" + Main.connect.movies.get(0).get(9));
                imgOne.setImage(image);
                labelOne.setText(Main.connect.movies.get(0).get(1));
            }
        });
        moviesRepertoire.getTodaysDay();
        moviesRepertoire.currentMovie();
        setInfo();
        System.out.println(Main.connect.movies.size());
    }


    public void setInfo(){
        for(int i=moviesRepertoire.flag;i<6;i++){
            if(moviesRepertoire.flag>=Main.connect.movies.size()){
                break;
            }
            else if(Main.connect.movies.size()==1) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1));
                    moviesRepertoire.flag = 1;
                }
            else if(Main.connect.movies.size()==2) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1));
                    moviesRepertoire.flag = 2;
                }
            else if(Main.connect.movies.size()==3) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+2).get(9));
                    imgThree.setImage(image);
                    labelThree.setText(Main.connect.movies.get(i+2).get(1));
                    moviesRepertoire.flag = 3;
                }
            else if(Main.connect.movies.size()==4) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+2).get(9));
                    imgThree.setImage(image);
                    labelThree.setText(Main.connect.movies.get(i+2).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+3).get(9));
                    imgFour.setImage(image);
                    labelFour.setText(Main.connect.movies.get(i+3).get(1));
                    moviesRepertoire.flag = 4;
                }
            else if(Main.connect.movies.size()==5) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+2).get(9));
                    imgThree.setImage(image);
                    labelThree.setText(Main.connect.movies.get(i+2).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+3).get(9));
                    imgFour.setImage(image);
                    labelFour.setText(Main.connect.movies.get(i+3).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+4).get(9));
                    imgFive.setImage(image);
                    labelFive.setText(Main.connect.movies.get(i+4).get(1));
                    moviesRepertoire.flag = 5;
                }
            else if(Main.connect.movies.size()==6) {
                    Image image = new Image("file:" + Main.connect.movies.get(i).get(9));
                    imgOne.setImage(image);
                    labelOne.setText(Main.connect.movies.get(i).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+1).get(9));
                    imgTwo.setImage(image);
                    labelTwo.setText(Main.connect.movies.get(i+1).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+2).get(9));
                    imgThree.setImage(image);
                    labelThree.setText(Main.connect.movies.get(i+2).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+3).get(9));
                    imgFour.setImage(image);
                    labelFour.setText(Main.connect.movies.get(i+3).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+4).get(9));
                    imgFive.setImage(image);
                    labelFive.setText(Main.connect.movies.get(i+4).get(1));
                    image = new Image("file:" + Main.connect.movies.get(i+5).get(9));
                    imgSix.setImage(image);
                    labelSix.setText(Main.connect.movies.get(i+5).get(1));
                    moviesRepertoire.flag = 6;
                }
            }
        moviesRepertoire.flag = 0;
    }
}
