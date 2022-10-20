module com.example.jang {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.jang to javafx.fxml;
  exports com.example.jang;
}