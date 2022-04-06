package pl.cinema.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main class for our cinema booking management application
 *
 * @author Krzysztof Ksiazek
 * @author Jakub Fik
 * @since 31.03.2022
 *
 */

public class Main extends Application {

    private static Scene scene;

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
        scene = new Scene(loadFXML("mainPane"));
        stage.setScene(scene);
        stage.setTitle("Cinema");
        stage.setResizable(false); //TODO false
        stage.show();
       // Platform.exit(); Metoda ktora rowniez powoduje zatrzymanie aplikacji
    }

    /**
     *
     * @param fxml
     * @throws IOException
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     *
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
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
