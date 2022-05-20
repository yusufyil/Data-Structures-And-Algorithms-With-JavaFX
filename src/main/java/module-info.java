module com.example.ds {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ds to javafx.fxml;
    exports com.example.ds;
}