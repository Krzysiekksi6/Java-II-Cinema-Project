package pl.cinema.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.cinema.app.Main;

import java.io.IOException;

public class LoginPaneController {

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private TextField usernameBox;

    @FXML
    private Label toastLabel;

    @FXML
    private Button backButton;




    /**
     *
     */
    public void initialize() {
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
        logInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!usernameBox.getText().isEmpty() && !passwordBox.getText().isEmpty()) {
                    if (usernameBox.getText().equals("employee") && passwordBox.getText().equals("employee")) {
                        toastLabel.setText("");
                        try {

                            Main.setRoot("employeePane");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (usernameBox.getText().equals("chef") && passwordBox.getText().equals("chef")) {
                        toastLabel.setText("");
                        try {

                            Main.setRoot("chefPane");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        toastLabel.setText("Incorrect data!");
                    }
                } else {
                    toastLabel.setText("Data can not be empty!");
                }
            }
        });
    }

}
