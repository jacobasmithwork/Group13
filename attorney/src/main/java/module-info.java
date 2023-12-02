module group13 {
    requires javafx.controls;
    requires javafx.fxml;
    exports group13;
    opens group13 to javafx.fxml;
}