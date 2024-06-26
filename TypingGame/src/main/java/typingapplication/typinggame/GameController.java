package typingapplication.typinggame;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class GameController {
    @FXML
    private Label wordToType = new Label();
    @FXML
    private TextArea inputText = new TextArea();
    @FXML
    Label timerLabel = new Label();
    @FXML
    Button seeResults = new Button();
    int correctTypes = 0;
    public void generateWord() {
        wordToType.setText(GameModel.getRandomWord());
    }

    public void compareWord(KeyEvent e) throws IOException {
        if(inputText.getText().equals(wordToType.getText())) {
            correctTypes++;
            generateWord();
            inputText.clear();
        }
        if(inputText.getText().equals("\n")){
            goToResults(e);
        }
    }


    public void runTimer(){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int counter = 60;
            @Override
            public void run() {
                if(counter > 0) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            timerLabel.setText(String.valueOf(counter));
                        }
                    });
                    counter--;
                }
                else {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            timerLabel.setText("Time's up!");
                            timerLabel.setTextFill(Color.RED);
                            inputText.setEditable(false);
                            seeResults.setVisible(true);
                            timer.cancel();
                        }
                    });
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void goToResults(Event e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("results-view.fxml"));
        Parent root = loader.load();
        ResultsController resultsController = loader.getController();
        resultsController.showScore(correctTypes);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
