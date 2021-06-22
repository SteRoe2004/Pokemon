package sample.fight;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

public class FightController {


    @FXML
    private Button fightButton;

    @FXML
    private Button teamButton;

    @FXML
    private Button bagButton;

    @FXML
    private Button escapeButton;

    @FXML
    private ProgressBar healthPlayer;

    @FXML
    private ProgressBar healthOpponent;

    @FXML
    private void initialize(){
        fightButton.setOnAction(event -> openMenu());
        teamButton.setOnAction(event -> showTeam());
        bagButton.setOnAction(event -> openBag());
        escapeButton.setOnAction(event -> escapeFight());


    }


    @FXML
    private void openMenu(){

        System.out.println("Test");
    }

    @FXML
    private void showTeam(){

        System.out.println("Test2");
    }

    @FXML
    private void openBag(){

        System.out.println("test3");
    }

    @FXML
    private void escapeFight(){

        System.out.println("Test4");
    }

}

