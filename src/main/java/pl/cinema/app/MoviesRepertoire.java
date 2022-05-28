package pl.cinema.app;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//Potrzebuje tablicy z filmem, potem kolejne ktore je ma i pot
public class MoviesRepertoire {

    private String presentDate;

    public int getFlag() {
        return flag;
    }

    public int flag=0;


    public void getTodaysDay(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        presentDate = dtf.format(now);
    }

    public void currentMovie() throws SQLException {
        Main.connect.queryMovies(presentDate);
        System.out.println(presentDate);
        System.out.println(Main.connect.movies.size());
    }


}
