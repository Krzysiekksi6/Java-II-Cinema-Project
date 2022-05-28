package pl.cinema.app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Connection module-info tam szukać jakby coś nie działało

public class Connect {

    public ArrayList<ArrayList<String>> movies = new ArrayList<>();

    public ArrayList<String> moviesTimeStart = new ArrayList<>();

    public static String passwd=null;

    static List<String> jdbcCollumn = new ArrayList<>();

    private String driver = "org.postgresql.Driver";

    private String host = "195.150.230.210";

    private String port = "5436";

    private String dbname = "2022_ksiazek_krzysztof";
    private String user = "2022_ksiazek_krzysztof";

    private String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbname;
    private String pass = "34301";

    private final String queryPrice = "SELECT * FROM roznosci.cennik;";

    Statement stmt;

    public static String tableName="null";

    public static final String[] PATTERN_QUERY = {"SELECT * FROM dziekanat.","SELECT * FROM kadry."};

    public static String query = "SELECT * FROM dziekanat.studenci";

    private Connection connection;

    String imie;

    public int indeks;

    private List<String> tablesName = new ArrayList<>();

    public static List<String> emails = new ArrayList<>();

    public Connect() {

        connection = makeConnection();

    }

    public Connection getConnection() {

        return (connection);

    }

    public void close() {

        try {

            connection.close();
        } catch (SQLException sqle) {
            System.err.println("Blad przy zamykaniu polaczenia: " + sqle);

        }
    }

    public Connection makeConnection() {
        try {

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, pass);
            stmt = connection.createStatement();
            return (connection);

        } catch (ClassNotFoundException cnfe) {

            System.err.println("Blad ladowania sterownika: " + cnfe);

            return (null);
        } catch (SQLException sqle) {

            System.err.println("Blad przy nawiązywaniu polaczenia: " + sqle);

            return (null);
        }


    }

    public void queryMovies(String data) throws SQLException {
                Statement stmt = connection.createStatement();
                query = "SELECT * FROM roznosci.bazafilmow " +
                        "WHERE data_filmu::varchar LIKE " + "\'"+ data + "%" + "\';";
                ResultSet rs = stmt.executeQuery(query);
                movies.clear();
                while (rs.next()) {
                    ArrayList<String> movie = new ArrayList<>();
                    String id_filmu = rs.getString("id_filmu");
                    String nazwa_filmu = rs.getString("nazwa_filmu");
                    String kategoria_filmu = rs.getString("kategoria_filmu");
                    String data_filmu = rs.getString("data_filmu");
                    String godzina_rozpoczecia  = rs.getString("godzina_rozpoczecia");
                    String czas_trwania_minuty = rs.getString("czas_trwania_minuty");
                    String godzina_zakonczenia = rs.getString("godzina_zakonczenia");
                    String sala = rs.getString("sala");
                    String min_wiek = rs.getString("min_wiek");
                    String obraz_filmu = rs.getString("obraz_filmu");
                    String forma_dzwieku = rs.getString("forma_dzwieku");
                    movie.add(id_filmu);
                    movie.add(nazwa_filmu);
                    movie.add(kategoria_filmu);
                    movie.add(data_filmu);
                    movie.add(godzina_rozpoczecia);
                    movie.add(czas_trwania_minuty);
                    movie.add(godzina_zakonczenia);
                    movie.add(sala);
                    movie.add(min_wiek);
                    movie.add(obraz_filmu);
                    movie.add(forma_dzwieku);
                    movies.add(movie);
                }
        }

    public void queryGetTime(String movieName) throws SQLException {
        Statement stmt = connection.createStatement();
        query = "SELECT id_filmu,godzina_rozpoczecia FROM roznosci.bazafilmow " +
                "WHERE nazwa_filmu LIKE " + "\'"+ movieName + "%" + "\';";
        ResultSet rs = stmt.executeQuery(query);
        moviesTimeStart.clear();
        while (rs.next()) {
            String id = rs.getString("id_filmu");
            String godzina_rozpoczecia  = rs.getString("godzina_rozpoczecia");
            String added = id +'.'+ godzina_rozpoczecia;
            moviesTimeStart.add(added);
        }

    }


    public void getTables() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        String[] types = {"TABLE"};
        //Retrieving the columns in the database
        ResultSet tables = metaData.getTables(null, "kadry", null, types);
        while (tables.next()) {
            tablesName.add(tables.getString("TABLE_NAME"));
        }

    }

    public List<String> getTablesName() {
        return tablesName;
    }

    public String mkQuery(){
        if(tableName.contains("jednostki_organizacyjne")||tableName.contains("prowadzacy")||tableName.contains("wyplaty")){
            return PATTERN_QUERY[1]+tableName;
        }
        else{
            return PATTERN_QUERY[0]+tableName;
        }
    }

    public void gettingDataInputData(TableView tableView,String queryM) {
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try {
            Connection connection = makeConnection();
            ResultSet rs = connection.createStatement().executeQuery(queryM);

            for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {
                int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                if (rs.getMetaData().getColumnName(i + 1).contains("email")) {
                    indeks = i + 1;
                }
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }


            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    if (rs.getString(i) == null) {
                        row.add("null");
                    } else {
                        row.add(rs.getString(i));
                        if (i == indeks) {
                            emails.add(rs.getString(i));
                        }
                    }
                }
                data.add(row);

            }
            System.out.println("Pobrano dane,zapytanie:" + getQueryPrice());
            System.out.println(emails.toString());
            tableView.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nie udalo sie pobrac");
        }
    }



    public void addMovieToBase(String idMovie,String nameOfMovie,
                               String movieCategory,String startTime,String howLong,
                               String endTime,String Hall,String minimumAge,String picture,String typeOfScreen,String date){
        //to test
        /*
        	EXAMPLE
	INSERT INTO roznosci.bazafilmow
	(id_filmu,nazwa_filmu,kategoria_filmu,godzina_rozpoczecia
	 ,czas_trwania_minuty,godzina_zakonczenia,sala,min_wiek,obraz_filmu
	 ,forma_dzwieku,data_filmu)
	VALUES
		(3,'Americano2','Action','14:20',120,'14:30','C2',17,null,'2d','17.10.2020');
         */
        try(Connection conn = DriverManager.getConnection(url, user, pass);
        ) {
            String sql = "INSERT INTO roznosci.bazafilmow " +
                    "(id_filmu,nazwa_filmu,kategoria_filmu,godzina_rozpoczecia,czas_trwania_minuty,godzina_zakonczenia,sala,min_wiek," +
                    "obraz_filmu,forma_dzwieku,data_filmu) " +
                    "VALUES" +
                    '(' + idMovie + "," +  "\'" + nameOfMovie + "\'"  + ',' +  "\'" + movieCategory + "\'"  + ',' +  "\'" + startTime + "\'"  + ',' +  howLong   +
                    ',' + "\'" + endTime + "\'"  + ',' +  "\'" + Hall + "\'"  + ',' + minimumAge + ',' +  "\'" + picture + "\'"  +','+  "\'" + typeOfScreen + "\'"  + ',' +  "\'" + date + "\'" +  ')';

            stmt.executeUpdate(sql);
            System.out.println("Added to datebase");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getPasswd() {
        return passwd;
    }

    public static void setPasswd(String passwd) {
        Connect.passwd = passwd;
    }

    public String getQueryPrice() {
        return queryPrice;
    }

    public String idGenerator() throws SQLException {
        Statement statement = connection.createStatement();

        String query = "SELECT id_filmu FROM roznosci.bazafilmow";
        ResultSet rs = statement.executeQuery(query);
        String id = new String();
        ArrayList<String> ids = new ArrayList<>();

        while(rs.next()){
            id = rs.getString("id_filmu");
            ids.add(id);
        }
        id = "0";
        for(int i=1;i>0;i++) {
            boolean a = false;
            for (String idCheck : ids) {
                if (idCheck.contains(String.valueOf(i))){
                    a = true;
                }
            }
            if(a == false){
                id = String.valueOf(i);
                break;
            }
        }

        return id;
    }
    public void reserveSeat(ArrayList<String> data, Label l){
        String id = l.getText();

    }

    public String idGeneratorReservation() throws SQLException {
        Statement statement = connection.createStatement();

        String query = "SELECT id_rezerwacji FROM roznosci.rezerwacje2";
        ResultSet rs = statement.executeQuery(query);
        String id = new String();
        ArrayList<String> ids = new ArrayList<>();

        while(rs.next()){
            id = rs.getString("id_rezerwacji");
            ids.add(id);
        }
        id = "0";
        for(int i=1;i>0;i++) {
            boolean a = false;
            for (String idCheck : ids) {
                if (idCheck.contains(String.valueOf(i))){
                    a = true;
                }
            }
            if(a == false){
                id = String.valueOf(i);
                break;
            }
        }

        return id;
    }
    /*
    public void reserveSeat(ArrayList<String> data, Label l){
        String id = l.getText();

    }

     */

    public void addReservationToBase(String id_rezerwacji,String id_filmu,String status,String nr_telefonu,String miejsce){
        //to test
        /*
        	EXAMPLE
	INSERT INTO roznosci.bazafilmow
	(id_filmu,nazwa_filmu,kategoria_filmu,godzina_rozpoczecia
	 ,czas_trwania_minuty,godzina_zakonczenia,sala,min_wiek,obraz_filmu
	 ,forma_dzwieku,data_filmu)
	VALUES
		(3,'Americano2','Action','14:20',120,'14:30','C2',17,null,'2d','17.10.2020');
         */
        try(Connection conn = DriverManager.getConnection(url, user, pass);
        ) {
            String sql = "INSERT INTO roznosci.rezerwacje2 " +
                    "(id_rezerwacji,id_filmu,status,nr_telefonu,miejce) " +
                    "VALUES" +
                    '(' + id_rezerwacji + "," +  id_filmu  + ',' +  "\'" + status + "\'"  + ',' +  "\'" + nr_telefonu + "\'"  + ',' + "\'" + miejsce + "\'" + ')';

            stmt.executeUpdate(sql);
            System.out.println("Added to datebase");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] findById(String id) throws SQLException {
        Statement stmt = connection.createStatement();
        String[] movieInformation = new String[11];

        query = "SELECT * FROM roznosci.bazafilmow " +
                "WHERE id_filmu = " + id + ";";

        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            ArrayList<String> movie = new ArrayList<>();
            String id_filmu = rs.getString("id_filmu");
            String nazwa_filmu = rs.getString("nazwa_filmu");
            String kategoria_filmu = rs.getString("kategoria_filmu");
            String data_filmu = rs.getString("data_filmu");
            String godzina_rozpoczecia  = rs.getString("godzina_rozpoczecia");
            String czas_trwania_minuty = rs.getString("czas_trwania_minuty");
            String godzina_zakonczenia = rs.getString("godzina_zakonczenia");
            String sala = rs.getString("sala");
            String min_wiek = rs.getString("min_wiek");
            String obraz_filmu = rs.getString("obraz_filmu");
            String forma_dzwieku = rs.getString("forma_dzwieku");
            movieInformation[0] = id_filmu;
            movieInformation[1] =nazwa_filmu;
            movieInformation[2] =kategoria_filmu;
            movieInformation[3] =data_filmu;
            movieInformation[4] =godzina_rozpoczecia;
            movieInformation[5] =czas_trwania_minuty;
            movieInformation[6] =godzina_zakonczenia;
            movieInformation[7] =sala;
            movieInformation[8] =min_wiek;
            movieInformation[9] =obraz_filmu;
            movieInformation[10] =forma_dzwieku;
        }
        return movieInformation;
    }
    public String getByIdReservations(String id) throws SQLException {

        Statement stmt = connection.createStatement();
        String reservations = "";

        query = "SELECT miejce FROM roznosci.rezerwacje2 " +
                "WHERE id_filmu = " + id + ";";

        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String rsGet = rs.getString("miejce");
            if(reservations.isEmpty())
            reservations = rsGet;
            else{
                reservations = reservations + "," + rsGet;
            }
        }
        return reservations;
    }



    public String[] findByIdReservation(String id) throws SQLException {
        Statement stmt = connection.createStatement();
        String[] movieInformation = new String[11];

        query = "SELECT * FROM roznosci.bazafilmow " +
                "WHERE id_filmu = " + id + ";";

        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            ArrayList<String> movie = new ArrayList<>();
            String id_filmu = rs.getString("id_filmu");
            String nazwa_filmu = rs.getString("nazwa_filmu");
            String kategoria_filmu = rs.getString("kategoria_filmu");
            String data_filmu = rs.getString("data_filmu");
            String godzina_rozpoczecia  = rs.getString("godzina_rozpoczecia");
            String czas_trwania_minuty = rs.getString("czas_trwania_minuty");
            String godzina_zakonczenia = rs.getString("godzina_zakonczenia");
            String sala = rs.getString("sala");
            String min_wiek = rs.getString("min_wiek");
            String obraz_filmu = rs.getString("obraz_filmu");
            String forma_dzwieku = rs.getString("forma_dzwieku");
            movieInformation[0] = id_filmu;
            movieInformation[1] =nazwa_filmu;
            movieInformation[2] =kategoria_filmu;
            movieInformation[3] =data_filmu;
            movieInformation[4] =godzina_rozpoczecia;
            movieInformation[5] =czas_trwania_minuty;
            movieInformation[6] =godzina_zakonczenia;
            movieInformation[7] =sala;
            movieInformation[8] =min_wiek;
            movieInformation[9] =obraz_filmu;
            movieInformation[10] =forma_dzwieku;
        }
        return movieInformation;
    }



}


