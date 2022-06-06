package pl.cinema.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Główna klasa aplikacji
 * @author Krzysztof Ksiazek
 * @author Jakub Fik
 * @since 31.03.2022
 *
 */

public class Main extends Application {

    private static Scene scene;
    public static Connect connect = new Connect();

    /**
     * Konstruktor głównej klasy
     */
    public Main() {
        //System.out.println("Constructor");
    }

    /**
     * Metoda startowa aplikacji
     * @param stage stage
     * @throws Exception
     */

    @Override
    public void start(Stage stage) throws Exception {
       // System.out.println("Start");
        scene = new Scene(loadFXML("mainPane"));
        stage.setScene(scene);
        stage.setTitle("Cinema");
        stage.setResizable(false); //TODO false
        stage.show();
       // Platform.exit(); Metoda ktora rowniez powoduje zatrzymanie aplikacji
    }

    /**
     * Metoda odpowiedzialna za zmiane Activity
     * @param fxml fxml
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Metoda pomocniczna zmiany Activity
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }


    /**
     * Metoda ktora moze zostac uzyta na potrzeby odtwarzania poprzedniego stanu aplikacji
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        //System.out.println("Init");
    }

    /**
     * Metoda ktora moze zostac uzyta do zapisania stanu aplikacji
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
       // System.out.println("Stop");
    }

    /**
     * Główna metoda aplikacji
     * @param args args
     */
    public static void main(String[] args) {
        //System.out.println("Main");
        try {
            System.out.println(connect.idGenerator());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        launch(args);
    }


}
