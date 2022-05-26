package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pl.cinema.app.Main;

import javax.mail.search.SearchTerm;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class ReservationPaneController {

    static int howManyTickets = 0;

    boolean checkerForClearing = false;

    String info;

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
    Label lOneOne;
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
    Label lTwoTwo;
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
    AnchorPane archonPaneReser;

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

    ArrayList<String> data = new ArrayList<>();

    static ArrayList<ArrayList<String>> dataToReserve = new ArrayList<>();

    static String nameOfMovie;

    ArrayList<String> idMovie = new ArrayList<>();

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
       //System.out.println(Main.connect.movies.get(1));
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
        setFreeSeats();
        reservationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                howManyTickets = dataToReserve.size();
                nameOfMovie = chooseMovie.getText();
                //try {
                 //   Main.connect.addReservationToBase(Main.connect.idGeneratorReservation(),dataToReserve.get(0).get(1),"eee","998","EEEEE");
                //} catch (SQLException e) {
                //    e.printStackTrace();
               // }
                String[] a = new String[0];
                try {
                    a = Main.connect.findById("1");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(Arrays.toString(a));
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(CompleteOrderController.class.getResource("/fxml/completeOrder.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(),651,322);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Add movie");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
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
                setSelected(rZeroZero,lZeroZero);
            }
        });
        lZeroOne.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rZeroOne,lZeroOne);
            }
        });
        lZeroTwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rZeroTwo,lZeroTwo);
            }
        });
        lZeroThree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rZeroThree,lZeroThree);
            }
        });
        lZeroFour.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rZeroFour,lZeroFour);
            }
        });
        lZeroFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rZeroFive,lZeroFive);
            }
        });
        lOneZero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rOneZero,lOneZero);
            }
        });
        lOneOne.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rOneOne,lOneOne);
            }
        });
        lOneTwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rOneTwo,lOneTwo);
            }
        });
        lOneThree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rOneThree,lOneThree);
            }
        });
        lOneFour.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rOneFour,lOneFour);
            }
        });
        lOneFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rOneFive,lOneFive);
            }
        });
        lTwoZero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rTwoZero,lTwoZero);
            }
        });
        lTwoOne.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rTwoOne,lTwoOne);
            }
        });
        lTwoThree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rTwoThree,lTwoThree);
            }
        });
        lTwoFour.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rTwoFour,lTwoFour);
            }
        });
        lTwoFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rTwoFive,lTwoFive);
            }
        });
        lThreeZero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rThreeZero,lThreeZero);
            }
        });
        lThreeOne.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rThreeOne,lThreeOne);
            }
        });
        lThreeTwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rThreeTwo,lThreeTwo);
            }
        });
        lThreeThree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rThreeThree,lThreeThree);
            }
        });
        lThreeFour.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rThreeFour,lThreeFour);
            }
        });
        lThreeFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rThreeFive,lThreeFive);
            }
        });
        lFourZero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFourZero,lFourZero);
            }
        });
        lFourOne.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFourOne,lFourOne);
            }
        });
        lFourTwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFourTwo,lFourTwo);
            }
        });
        lFourThree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFourThree,lFourThree);
            }
        });
        lFourFour.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFourFour,lFourFour);
            }
        });
        lFourFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFourFive,lFourFive);
            }
        });
        lFiveZero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFiveZero,lFiveZero);
            }
        });
        lFiveOne.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFiveOne,lFiveOne);
            }
        });
        lFiveTwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFiveTwo,lFiveTwo);
            }
        });
        lFiveThree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFiveThree,lFiveThree);
            }
        });
        lFiveFour.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFiveFour,lFiveFour);
            }
        });
        lFiveFive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rFiveFive,lFiveFive);
            }
        });
        lTwoTwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setSelected(rTwoTwo,lTwoTwo);
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
                        data.clear();
                        String beforeSplit =  (((MenuItem) e.getSource()).getText());
                        String[] afterSplit = beforeSplit.split("\\.");
                        chooseTime.setText(afterSplit[1]);
                        //String[] afterSplit = ((MenuItem) e.getSource()).getText().split(".");
                        //chooseTime.setText(afterSplit[0]);
                        //String[] splliting = getter.split(".");
                        //chooseTime.setText(splliting[1]);

                        data.add(String.valueOf(datePicker.getValue()));

                        int id = Integer.parseInt(afterSplit[0]);

                        --id;

                        data.add(idMovie.get(id));

                        data.add(chooseMovie.getText());

                        data.add(chooseTime.getText());

                        info = idMovie.get(id);

                        try {
                            String[] reservations = Main.connect.getByIdReservations(idMovie.get(id)).split(",");
                            System.out.println(Arrays.toString(reservations));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        archonPaneReser.setVisible(true);

                        try {
                            setReservedSeats();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        System.out.println(data);

                    }
                };
                for (int i = 0; i < Main.connect.moviesTimeStart.size(); i++) {
                    String beforeSplit = Main.connect.moviesTimeStart.get(i);
                    String[] afterSplit = beforeSplit.split("\\.");
                    MenuItem menuItem2 = new MenuItem(String.valueOf(i+1) + "." + afterSplit[1]);
                    idMovie.add(afterSplit[0]);
                    menuItem2.setOnAction(event2);
                    chooseTime.getItems().add(menuItem2);

                }
                if(checkerForClearing==true){
                    chooseTime.getItems().clear();
                }
                checkerForClearing = true;
            }


        };
        for (int i = 0; i < Main.connect.movies.size(); i++) {
            MenuItem menuItem1 = new MenuItem(Main.connect.movies.get(i).get(1));
            menuItem1.setOnAction(event1);
            chooseMovie.getItems().add(menuItem1);
        }

    }

    @FXML
    public void setReserved(Rectangle r,Label l){
        r.setFill(Color.RED);
        l.setText("RESERVED");
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
    public void setSelected(Rectangle r,Label l){
        r.setFill(Color.BLUE);
        l.setText("Selected");
        String labelID = l.getId();

        labelID = labelID.substring(1);

        int flag = 0;
        String[] rowAndColumn  = new String[2];

        for(int i=0;i<labelID.length();i++){
            if(Character.isUpperCase(labelID.charAt(i))){
                flag++;
                if(flag > 1){
                    rowAndColumn[0]= labelID.substring(0,i);
                    rowAndColumn[1] = labelID.substring(i);
                }
            }
        }

        data.add(rowAndColumn[0]);
        data.add(rowAndColumn[1]);

        System.out.println(data);

        dataToReserve.add((ArrayList<String>) data.clone());

        data.remove(5);
        data.remove(4);

        System.out.println(dataToReserve);
        System.out.println(dataToReserve.size());
        System.out.println(rowAndColumn[0] + "," + rowAndColumn[1]);
    }

    public void setFreeSeats(){
        setFree(rZeroZero,lZeroZero);
        setFree(rZeroOne,lZeroOne);
        setFree(rZeroTwo,lZeroTwo);
        setFree(rZeroThree,lZeroThree);
        setFree(rZeroFour,lZeroFour);
        setFree(rZeroFive,lZeroFive);
        setFree(rOneZero,lOneZero);
        setFree(rOneOne,lOneOne);
        setFree(rOneTwo,lOneTwo);
        setFree(rOneThree,lOneThree);
        setFree(rOneFour,lOneFour);
        setFree(rOneFive,lOneFive);
        setFree(rTwoZero,lTwoZero);
        setFree(rTwoOne,lTwoOne);
        setFree(rTwoTwo,lTwoTwo);
        setFree(rTwoThree,lTwoThree);
        setFree(rTwoFour,lTwoFour);
        setFree(rTwoFive,lTwoFive);
        setFree(rThreeZero,lThreeZero);
        setFree(rThreeOne,lThreeOne);
        setFree(rThreeTwo,lThreeTwo);
        setFree(rThreeThree,lThreeThree);
        setFree(rThreeFour,lThreeFour);
        setFree(rThreeFive,lThreeFive);
        setFree(rFourZero,lFourZero);
        setFree(rFourOne,lFourOne);
        setFree(rFourTwo,lFourTwo);
        setFree(rFourThree,lFourThree);
        setFree(rFourFour,lFourFour);
        setFree(rFourFive,lFourFive);
        setFree(rFiveZero,lFiveZero);
        setFree(rFiveOne,lFiveOne);
        setFree(rFiveTwo,lFiveTwo);
        setFree(rFiveThree,lFiveThree);
        setFree(rFiveFour,lFiveFour);
        setFree(rFiveFive,lFiveFive);


    }

    public void setReservedSeats() throws SQLException {
        //rezerwacja na switach kolorująca przyciski w kurwe do roboty
        //trzeba dla kazdego przypadku zrobic case i lecim dalej
        //case zawiera zero,two -> recntagle.setColor,label.setText
        String[] reservations = Main.connect.getByIdReservations(info).split(",");
        for(int i=0;i<reservations.length-1;i++){
            switch((reservations[i] + reservations[i+1])){
            case "ZeroZero" -> setReserved(rZeroZero,lZeroZero);
            case "ZeroOne" -> setReserved(rZeroOne,lZeroOne);
            case "ZeroTwo" ->setReserved(rZeroTwo,lZeroTwo);
            case "ZeroThree" ->setReserved(rZeroThree,lZeroThree);
            case "ZeroFour" ->setReserved(rZeroFour,lZeroFour);
            case "ZeroFive" ->setReserved(rZeroFive,lZeroFive);
            case "OneZero"  -> setReserved(rOneZero,lOneZero);
            case "OneOne" ->setReserved(rOneOne,lOneOne);
            case "OneTwo"  -> setReserved(rOneTwo,lOneTwo);
            case "OneThree" -> setReserved(rOneThree,lOneThree);
            case "OneFour" -> setReserved(rOneFour,lOneFour);
            case "OneFive" -> setReserved(rOneFive,lOneFive);
            case "TwoZero" ->  setReserved(rTwoZero,lTwoZero);
            case "TwoOne" ->  setReserved(rTwoOne,lTwoOne);
            case "TwoTwo" ->  setReserved(rTwoTwo,lTwoTwo);
            case "TwoThree" ->  setReserved(rTwoThree,lTwoThree);
            case "TwoFour" ->  setReserved(rTwoFour,lTwoFour);
            case "TwoFive" ->  setReserved(rTwoFive,lTwoFive);
            case "ThreeZero" ->  setReserved(rThreeZero,lThreeZero);
            case "ThreeOne" ->  setReserved(rThreeOne,lThreeOne);
            case "ThreeTwo" ->  setReserved(rThreeTwo,lThreeTwo);
            case "ThreeThree" ->  setReserved(rThreeThree,lThreeThree);
            case "ThreeFour" ->  setReserved(rThreeFour,lThreeFour);
            case "ThreeFive" ->  setReserved(rThreeFive,lThreeFive);
            case "FourZero" ->  setReserved(rFourZero,lFourZero);
            case "FourOne" ->  setReserved(rFourOne,lFourOne);
            case "FourTwo" ->  setReserved(rFourTwo,lFourTwo);
            case "FourThree" -> setReserved(rFourThree,lFourThree);
            case "FourFour" -> setReserved(rFourFour,lFourFour);
            case "FourFive" -> setReserved(rFourFive,lFourFive);
            case "FiveZero" -> setReserved(rFiveZero,lFiveZero);
            case "FiveOne" ->  setReserved(rFiveOne,lFiveOne);
            case "FiveTwo" ->  setReserved(rFiveTwo,lFiveTwo);
            case "FiveThree" -> setReserved(rFiveThree,lFiveThree);
            case "FiveFour" ->  setReserved(rFiveFour,lFiveFour);
            case "FiveFive" -> setReserved(rFiveFive,lFiveFive);

            }
        }
    }


}
