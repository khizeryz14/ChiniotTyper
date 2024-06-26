package typingapplication.typinggame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("intro-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
        stage.setTitle("Chiniot Typer");
        stage.setScene(scene);
        //add correct path below
        stage.getIcons().add(new Image("C:\\Khizer Projects (CPP)\\Java OOP\\TypingGame\\src\\main\\resources\\typingapplication\\typinggame\\output-onlinepngtools (2).png"));
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}