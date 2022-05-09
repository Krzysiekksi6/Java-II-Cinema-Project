package pl.cinema.app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Connection module-info tam szukać jakby coś nie działało

public class Connect {

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

    public void gettingDataInputData(TableView tableView,String queryM){
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try{
            Connection connection = makeConnection();
            ResultSet rs = connection.createStatement().executeQuery(queryM);

            for(int i=1 ; i<rs.getMetaData().getColumnCount(); i++){
                int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                if(rs.getMetaData().getColumnName(i+1).contains("email")){
                    indeks = i+1;
                }
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList,String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }


            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    if(rs.getString(i)==null) {
                        row.add("null");
                    }
                    else {
                        row.add(rs.getString(i));
                        if(i==indeks){
                            emails.add(rs.getString(i));
                        }
                    }
                }
                data.add(row);

            }
            System.out.println("Pobrano dane,zapytanie:"+getQueryPrice());
            System.out.println(emails.toString());
            tableView.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Nie udalo sie pobrac");
        }
    }

    public void CreateTable(){
        // Open a connection
        try(Connection conn = DriverManager.getConnection(url, user, pass);
        ) {
            String sql = "CREATE TABLE roznosci.REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
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
}