module com.example.aoop_assignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aoop_assignment to javafx.fxml;
    exports com.example.aoop_assignment;
}