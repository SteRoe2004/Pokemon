package sample.end;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URISyntaxException;

import static sample.Main.loader;
import static sample.Main.primaryStage;


public class EndController {

    @FXML
    private Button returntostartButton;

    @FXML
    private void initialize() {
        returntostartButton.setOnAction(event -> {
            try {
                sceneSwitch(event);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void sceneSwitch(ActionEvent event) throws IOException, URISyntaxException {

        Parent root = loader.load(getClass().getResource("/start.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
    }


}
