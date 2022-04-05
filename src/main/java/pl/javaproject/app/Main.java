package pl.javaproject.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * The main class for our cinema booking management application
 *
 * @author Krzysztof Ksiazek
 * @author Jakub Fik
 * @since 31.03.2022
 *
 *
 */

public class Main extends Application {

    //TODO Parent and setRoot

    /**
     * Constructor off Main Class
     */
    public Main() {
        System.out.println("Constructor");
    }

    /**
     * Start method off Application
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Start");
        stage.setTitle("Cinema");
        stage.show();
       // Platform.exit(); Metoda ktora rowniez powoduje zatrzymanie aplikacji
    }

    /**
     * Method that can be use for read application state
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        System.out.println("Init");
    }

    /**
     * Method that can be use for save application state
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        System.out.println("Stop");
    }

    /**
     * The main method that
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Main");
        launch(args);
    }


}
