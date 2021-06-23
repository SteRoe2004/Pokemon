package sample.start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static sample.Main.loader;
import static sample.Main.primaryStage;

public class StartController {

    @FXML
    private Button startButton;

    @FXML
    private void initialize(){

        startButton.setOnAction(event -> {
            try {
                sceneSwitch(event);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    private void sceneSwitch(ActionEvent event) throws IOException, URISyntaxException {

        Parent root = loader.load(getClass().getResource("/fight.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}

