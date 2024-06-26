module typingapplication.typinggame {
    requires javafx.controls;
    requires javafx.fxml;


    opens typingapplication.typinggame to javafx.fxml;
    exports typingapplication.typinggame;
}