module Cinema.Booking.System {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires activation;
    requires kernel;
    requires layout;
    requires barcodes;

    exports pl.cinema.app;
    exports pl.cinema.controller;
    opens pl.cinema.app;
    opens pl.cinema.controller;
}