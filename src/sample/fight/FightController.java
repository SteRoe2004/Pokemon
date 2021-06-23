package sample.fight;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URISyntaxException;

import static sample.Main.loader;
import static sample.Main.primaryStage;

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
    private Button attackmove1;

    @FXML
    private Button attackmove2;

    @FXML
    private Button attackmove3;

    @FXML
    private Button attackmove4;

    @FXML
    private Button pokemon1;

    @FXML
    private Button pokemon2;

    @FXML
    private Button pokemon3;

    @FXML
    private Button pokemon4;

    @FXML
    private Button pokemon5;

    @FXML
    private Button pokemon6;

    @FXML
    private Button item1;

    @FXML
    private Button item2;

    @FXML
    private Button item3;

    @FXML
    private Button item4;

    @FXML
    private Button runButton;

    @FXML
    private VBox vBoxFight;

    @FXML
    private VBox vBoxTeam;

    @FXML
    private VBox vBoxBag;

    @FXML
    private VBox vBoxEscape;



    @FXML
    private void initialize(){
        fightButton.setOnAction(event -> openMenu());
        teamButton.setOnAction(event -> showTeam());
        bagButton.setOnAction(event -> openBag());
        escapeButton.setOnAction(event -> escapeFight());

        attackmove1.setOnAction(event -> test());
        attackmove2.setOnAction(event -> test());
        attackmove3.setOnAction(event -> test());
        attackmove4.setOnAction(event -> test());

        attackmove1.setVisible(false);
        attackmove1.setDisable(true);
        attackmove2.setVisible(false);
        attackmove2.setDisable(true);
        attackmove3.setVisible(false);
        attackmove3.setDisable(true);
        attackmove4.setVisible(false);
        attackmove4.setDisable(true);

        pokemon1.setVisible(false);
        pokemon2.setVisible(false);
        pokemon3.setVisible(false);
        pokemon4.setVisible(false);
        pokemon5.setVisible(false);
        pokemon6.setVisible(false);
        pokemon1.setDisable(true);
        pokemon2.setDisable(true);
        pokemon3.setDisable(true);
        pokemon4.setDisable(true);
        pokemon5.setDisable(true);
        pokemon6.setDisable(true);

        pokemon1.setOnAction(event -> test());
        pokemon2.setOnAction(event -> test());
        pokemon3.setOnAction(event -> test());
        pokemon4.setOnAction(event -> test());
        pokemon5.setOnAction(event -> test());
        pokemon6.setOnAction(event -> test());

        item1.setDisable(true);
        item2.setDisable(true);
        item3.setDisable(true);
        item4.setDisable(true);
        item1.setVisible(false);
        item2.setVisible(false);
        item3.setVisible(false);
        item4.setVisible(false);

        item1.setOnAction(event -> test());
        item2.setOnAction(event -> test());
        item3.setOnAction(event -> test());
        item4.setOnAction(event -> test());

        runButton.setVisible(false);
        runButton.setDisable(true);

        runButton.setOnAction(event -> {
            try {
                returntostart(event);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });

    }


    @FXML
    private void openMenu(){
        attackmove1.setVisible(true);
        attackmove1.setDisable(false);
        attackmove1.setVisible(true);
        attackmove1.setDisable(false);
        attackmove2.setVisible(true);
        attackmove2.setDisable(false);
        attackmove3.setVisible(true);
        attackmove3.setDisable(false);
        attackmove4.setVisible(true);
        attackmove4.setDisable(false);

        pokemon1.setVisible(false);
        pokemon2.setVisible(false);
        pokemon3.setVisible(false);
        pokemon4.setVisible(false);
        pokemon5.setVisible(false);
        pokemon6.setVisible(false);
        pokemon1.setDisable(true);
        pokemon2.setDisable(true);
        pokemon3.setDisable(true);
        pokemon4.setDisable(true);
        pokemon5.setDisable(true);
        pokemon6.setDisable(true);

        item1.setDisable(true);
        item2.setDisable(true);
        item3.setDisable(true);
        item4.setDisable(true);
        item1.setVisible(false);
        item2.setVisible(false);
        item3.setVisible(false);
        item4.setVisible(false);

        runButton.setVisible(false);
        runButton.setDisable(true);

        vBoxFight.setDisable(false);
        vBoxTeam.setDisable(true);
        vBoxBag.setDisable(true);
        vBoxEscape.setDisable(true);

    }

    @FXML
    private void showTeam(){
        attackmove1.setVisible(false);
        attackmove1.setDisable(true);
        attackmove2.setVisible(false);
        attackmove2.setDisable(true);
        attackmove3.setVisible(false);
        attackmove3.setDisable(true);
        attackmove4.setVisible(false);
        attackmove4.setDisable(true);


        pokemon1.setVisible(true);
        pokemon2.setVisible(true);
        pokemon3.setVisible(true);
        pokemon4.setVisible(true);
        pokemon5.setVisible(true);
        pokemon6.setVisible(true);
        pokemon1.setDisable(false);
        pokemon2.setDisable(false);
        pokemon3.setDisable(false);
        pokemon4.setDisable(false);
        pokemon5.setDisable(false);
        pokemon6.setDisable(false);

        item1.setDisable(true);
        item2.setDisable(true);
        item3.setDisable(true);
        item4.setDisable(true);
        item1.setVisible(false);
        item2.setVisible(false);
        item3.setVisible(false);
        item4.setVisible(false);

        runButton.setVisible(false);
        runButton.setDisable(true);

        vBoxFight.setDisable(true);
        vBoxTeam.setDisable(false);
        vBoxBag.setDisable(true);
        vBoxEscape.setDisable(true);
    }

    @FXML
    private void openBag(){
        attackmove1.setVisible(false);
        attackmove1.setDisable(true);
        attackmove2.setVisible(false);
        attackmove2.setDisable(true);
        attackmove3.setVisible(false);
        attackmove3.setDisable(true);
        attackmove4.setVisible(false);
        attackmove4.setDisable(true);

        pokemon1.setVisible(false);
        pokemon2.setVisible(false);
        pokemon3.setVisible(false);
        pokemon4.setVisible(false);
        pokemon5.setVisible(false);
        pokemon6.setVisible(false);
        pokemon1.setDisable(true);
        pokemon2.setDisable(true);
        pokemon3.setDisable(true);
        pokemon4.setDisable(true);
        pokemon5.setDisable(true);
        pokemon6.setDisable(true);

        item1.setDisable(false);
        item2.setDisable(false);
        item3.setDisable(false);
        item4.setDisable(false);
        item1.setVisible(true);
        item2.setVisible(true);
        item3.setVisible(true);
        item4.setVisible(true);

        runButton.setVisible(false);
        runButton.setDisable(true);

        vBoxFight.setDisable(true);
        vBoxTeam.setDisable(true);
        vBoxBag.setDisable(false);
        vBoxEscape.setDisable(true);
    }

    @FXML
    private void escapeFight(){
        attackmove1.setVisible(false);
        attackmove1.setDisable(true);
        attackmove2.setVisible(false);
        attackmove2.setDisable(true);
        attackmove3.setVisible(false);
        attackmove3.setDisable(true);
        attackmove4.setVisible(false);
        attackmove4.setDisable(true);

        pokemon1.setVisible(false);
        pokemon2.setVisible(false);
        pokemon3.setVisible(false);
        pokemon4.setVisible(false);
        pokemon5.setVisible(false);
        pokemon6.setVisible(false);
        pokemon1.setDisable(true);
        pokemon2.setDisable(true);
        pokemon3.setDisable(true);
        pokemon4.setDisable(true);
        pokemon5.setDisable(true);
        pokemon6.setDisable(true);

        item1.setDisable(true);
        item2.setDisable(true);
        item3.setDisable(true);
        item4.setDisable(true);
        item1.setVisible(false);
        item2.setVisible(false);
        item3.setVisible(false);
        item4.setVisible(false);

        runButton.setVisible(true);
        runButton.setDisable(false);

        vBoxFight.setDisable(true);
        vBoxTeam.setDisable(true);
        vBoxBag.setDisable(true);
        vBoxEscape.setDisable(false);
    }

    @FXML
    private void test(){
        System.out.println("moin");
    }

    @FXML
    private void returntostart(ActionEvent event) throws IOException, URISyntaxException {

        Parent root = loader.load(getClass().getResource("/start.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
        }
    }



