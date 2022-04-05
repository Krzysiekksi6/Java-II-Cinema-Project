module Cinema.Booking.System {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pl.cinema.app;
    opens pl.cinema.app;
}