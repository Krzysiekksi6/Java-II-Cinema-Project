package pl.cinema.app;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MoviesRepertoire {

    private String presentDate;

    private int dynamicSize;

    public int getFlag() {
        return flag;
    }

    public int flag=0;

    /**
     * Funckja od pobierania dzisiejszej daty i zamieniania jej na odpowieni format
     */
    public void getTodaysDay(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        presentDate = dtf.format(now);
    }

    /**
     * Funckja która pobiera tytuł zjdęcie i godzine filmu
     * @throws SQLException
     */
    public void currentMovie() throws SQLException {
        Main.connect.queryMovies("2022-05-28");
        System.out.println(presentDate);
        System.out.println(Main.connect.movies.size());
    }

    public int getDynamicSize() {
        return dynamicSize;
    }

    public void setDynamicSize(int dynamicSize) {
        this.dynamicSize = dynamicSize;
    }
}
