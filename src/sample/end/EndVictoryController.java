package sample.end;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import java.io.IOException;
import java.net.URISyntaxException;

import static sample.Main.loader;
import static sample.Main.primaryStage;


public class EndVictoryController {

    @FXML
    public Button returnButton2;

    @FXML
    public void initialize() {
        returnButton2.setOnAction(event -> {
            try {
                sceneSwitch(event);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    public void sceneSwitch(ActionEvent event) throws IOException, URISyntaxException {

        Parent root = loader.load(getClass().getResource("/start.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}


/*        String musicFile = "StayTheNight.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play(); */
//TODO Wenn Musik dann hier eiin Beispiel
//TODO https://stackoverflow.com/questions/23202272/how-to-play-sounds-with-javafx
//TODO https://www.zophar.net/music/nintendo-3ds-3sf/pokemon-x
//TODO https://www.zophar.net/music/nintendo-ds-2sf/pokemon-heart-gold-soul-silver

