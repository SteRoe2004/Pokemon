package sample.fight;

import com.sun.xml.internal.ws.api.ha.HaInfo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.stats.AttackLib;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static sample.Main.loader;
import static sample.Main.primaryStage;

import sample.end.EndController;

public class FightController {

    private Pokemon mypokemon;
    private Pokemon opppokemon;

    private AttackLib lib;

    private Bag mybag;

    private Team myTeam;
    private Team oppTeam;


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
    private Label namemypokemon;

    @FXML
    private Label nameopppokemon;


    public IntegerProperty observerOwn;
    public IntegerProperty observerOpp;

    @FXML
    private void initialize() {

        lib = new AttackLib();

        initPokemon1();
        initPokemon2();
        initPokemon3();
        initPokemon4();
        initPokemon5();
        initPokemon6();

        initBag();

        initTeam();


        observerOwn = new SimpleIntegerProperty(opppokemon.getCurrentHP());
        observerOpp = new SimpleIntegerProperty(mypokemon.getCurrentHP());

        observerOpp.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                opppokemonDead((Integer) newValue);
            }
        });

        observerOwn.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mypokemonDead((Integer) newValue);
            }
        });


        healthPlayer.setProgress(1);
        healthOpponent.setProgress(1);

        namemypokemon.setText(mypokemon.getName());
        nameopppokemon.setText(opppokemon.getName());

        fightButton.setOnAction(event -> openMenu());
        teamButton.setOnAction(event -> showTeam());
        bagButton.setOnAction(event -> openBag());
        escapeButton.setOnAction(event -> escapeFight());

        attackmove1.setOnAction(event -> attack(1));
        attackmove2.setOnAction(event -> attack(2));
        attackmove3.setOnAction(event -> attack(3));
        attackmove4.setOnAction(event -> attack(4));

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

        pokemon1.setOnAction(event -> swappokemon(1));
        pokemon2.setOnAction(event -> swappokemon(2));
        pokemon3.setOnAction(event -> swappokemon(3));
        pokemon4.setOnAction(event -> swappokemon(4));
        pokemon5.setOnAction(event -> swappokemon(5));
        pokemon6.setOnAction(event -> swappokemon(6));

        item1.setDisable(true);
        item2.setDisable(true);
        item3.setDisable(true);
        item4.setDisable(true);
        item1.setVisible(false);
        item2.setVisible(false);
        item3.setVisible(false);
        item4.setVisible(false);

        item1.setOnAction(event -> heal(1));
        item2.setOnAction(event -> heal(2));
        item3.setOnAction(event -> heal(3));
        item4.setOnAction(event -> heal(4));


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


    public void mypokemonDead(Integer primaryStage) {
        observerOwn.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (mypokemon.getCurrentHP() <= 0) {
                    System.out.println("imagine dying");
                    sceneSwitch();
                }
            }
        });
    }

    public void opppokemonDead(Integer primaryStage) {
        observerOwn.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (mypokemon.getCurrentHP() <= 0) {

                    System.out.println("imgine dying");
                    sceneSwitch();
                }
            }
        });
    }

    private void initPokemon1() {
        this.mypokemon = new Pokemon("Charizard", 150, 400, 400, Type.FIRE, AttackLib.getAttacks(Type.FIRE, 4));
    }

    private void initPokemon2() {
        this.mypokemon = new Pokemon("Blastoise", 120, 410, 410, Type.WATER, AttackLib.getAttacks(Type.WATER, 4));

    }

    private void initPokemon3() {
        this.mypokemon = new Pokemon("Venusaur", 125, 415, 415, Type.GRASS, AttackLib.getAttacks(Type.GRASS, 4));

    }

    private void initPokemon4() {
        this.opppokemon = new Pokemon("Emboar", 100, 420, 420, Type.FIRE, AttackLib.getAttacks(Type.FIRE, 4));

    }

    private void initPokemon5() {
        this.opppokemon = new Pokemon("Samurott", 121, 405, 405, Type.WATER, AttackLib.getAttacks(Type.WATER, 4));

    }

    public void initPokemon6() {
        List<Attack> grassOnly = AttackLib.getAttacks(Type.GRASS, 4);
        this.opppokemon = new Pokemon("Serperior", 140, 390, 390, Type.GRASS, grassOnly);

    }

    private void initBag() {
        Item potion = new Item("Potion", 20);
        Item super_potion = new Item("Super Potion", 60);
        Item hyper_potion = new Item("Hyper Potion", 120);
        Item max_potion = new Item("MAX Potion", 500);
        this.mybag = new Bag(potion, super_potion, hyper_potion, max_potion);
    }

    private void initTeam() {
        Pokemon pokemon1 = new Pokemon("Venusaur", 125, 415, 415, Type.GRASS, AttackLib.getAttacks(Type.GRASS, 4));
        Pokemon pokemon2 = new Pokemon("Charizard", 150, 400, 400, Type.FIRE, AttackLib.getAttacks(Type.FIRE, 4));
        Pokemon pokemon3 = new Pokemon("Blastoise", 120, 410, 410, Type.WATER, AttackLib.getAttacks(Type.WATER, 4));
        this.myTeam = new Team(pokemon1, pokemon2, pokemon3);

        Pokemon pokemon4 = new Pokemon("Serperior", 140, 390, 390, Type.GRASS, AttackLib.getAttacks(Type.GRASS, 4));
        Pokemon pokemon5 = new Pokemon("Emboar", 100, 420, 420, Type.FIRE, AttackLib.getAttacks(Type.FIRE, 4));
        Pokemon pokemon6 = new Pokemon("Samurott", 121, 405, 405, Type.WATER, AttackLib.getAttacks(Type.WATER, 4));
        this.oppTeam = new Team(pokemon4, pokemon5, pokemon6);
    }


    @FXML
    private void openMenu() {
        attackmove1.setVisible(true);
        attackmove1.setDisable(false);
        attackmove2.setVisible(true);
        attackmove2.setDisable(false);
        attackmove3.setVisible(true);
        attackmove3.setDisable(false);
        attackmove4.setVisible(true);
        attackmove4.setDisable(false);

        attackmove1.setText(mypokemon.getAttack1().getName());
        attackmove2.setText(mypokemon.getAttack2().getName());
        attackmove3.setText(mypokemon.getAttack3().getName());
        attackmove4.setText(mypokemon.getAttack4().getName());

        attackmove1.setStyle("-fx-background-color: " + mypokemon.getAttack1().getType().getColour() + ";");
        attackmove2.setStyle("-fx-background-color: " + mypokemon.getAttack2().getType().getColour() + ";");
        attackmove3.setStyle("-fx-background-color: " + mypokemon.getAttack3().getType().getColour() + ";");
        attackmove4.setStyle("-fx-background-color: " + mypokemon.getAttack4().getType().getColour() + ";");

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
    private void showTeam() {
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

        pokemon1.setText(myTeam.getPokemon1().getName());
        pokemon2.setText(myTeam.getPokemon2().getName());
        pokemon3.setText(myTeam.getPokemon3().getName());
        //     pokemon4.setText(myTeam.getPokemon4().getName());
        //     pokemon5.setText(myTeam.getPokemon5().getName());
        //     pokemon6.setText(myTeam.getPokemon6().getName());
    }

    @FXML
    private void openBag() {
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

        item1.setText(mybag.getItem1().getName());
        item2.setText(mybag.getItem2().getName());
        item3.setText(mybag.getItem3().getName());
        item4.setText(mybag.getItem4().getName());

        runButton.setVisible(false);
        runButton.setDisable(true);

        vBoxFight.setDisable(true);
        vBoxTeam.setDisable(true);
        vBoxBag.setDisable(false);
        vBoxEscape.setDisable(true);
    }

    @FXML
    private void escapeFight() {
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
    private void attack(int number) {
        Attack attack;
        switch (number) {
            case 1:
                attack = mypokemon.getAttack1();
                break;
            case 2:
                attack = mypokemon.getAttack2();
                break;
            case 3:
                attack = mypokemon.getAttack3();
                break;
            case 4:
                attack = mypokemon.getAttack4();
                break;
            default:
                throw new RuntimeException();
        }
        System.out.println(mypokemon.getName() + " used attack " + attack.getName());
        int healthPlayer477 = mypokemon.getCurrentHP();
        int healthOpp = opppokemon.getCurrentHP();
        int newHealth = opppokemon.getCurrentHP() - attack.getDamage();
        double hpProgress = newHealth / (double) opppokemon.getMaxHP();
        System.out.println("Opp Hp before attack: " + opppokemon.getCurrentHP() + "Attack Str: " + attack.getDamage());
        opppokemon.setCurrentHP(newHealth);
        System.out.println("Opp Hp after attack: " + opppokemon.getCurrentHP() + "Calculated Hp after attack" + newHealth);

        if (hpProgress < 0) {
            hpProgress = 0;
        }
        if (hpProgress > 1) {
            hpProgress = 1;
        }

        this.healthOpponent.setProgress(hpProgress);


        switch ((int) (Math.random() * 4)) {
            case 1:
                attack = opppokemon.getAttack1();
                break;
            case 2:
                attack = opppokemon.getAttack2();
                break;
            case 3:
                attack = opppokemon.getAttack3();
                break;
            case 4:
                attack = opppokemon.getAttack4();
                break;
            default:
                throw new RuntimeException();
        }
        System.out.println(opppokemon.getName() + " used attack " + attack.getName());
        int healthPlayer1 = mypokemon.getCurrentHP();
        int newHealth2 = mypokemon.getCurrentHP() - attack.getDamage();
        double hpProgress2 = newHealth2 / (double) mypokemon.getMaxHP();
        mypokemon.setCurrentHP(newHealth2);

        if (hpProgress2 < 0) {
            hpProgress2 = 0;
        }
        if (hpProgress2 > 1) {
            hpProgress2 = 1;
        }


        healthPlayer.setStyle("-fx-accent: #49e020;");
        if (hpProgress2 < 0.5 ) {
        healthPlayer.setStyle("-fx-accent: #f6ba41;");
        }
        else if (hpProgress2 < 0.2) {
        healthPlayer.setStyle("-fx-accent: #fd1b10;");
        }

        healthOpponent.setStyle("-fx-accent: #49e020;");
        if (hpProgress < 0.5 ) {
        healthOpponent.setStyle("-fx-accent: #f6ba41;");
        }
        else if (hpProgress < 0.2) {
        healthOpponent.setStyle("-fx-accent: #fd1b10;");
        }

        this.healthPlayer.setProgress(hpProgress2);

    }


    @FXML
    private void heal(int number) {
        Item item;
        switch (number) {
            case 1:
                item = mybag.getItem1();
                break;
            case 2:
                item = mybag.getItem2();
                break;
            case 3:
                item = mybag.getItem3();
                break;
            case 4:
                item = mybag.getItem4();
                break;
            default:
                throw new RuntimeException();
        }
        System.out.println("You used " + item.getName());
        int heathPlayer1 = mypokemon.getCurrentHP();
        int newHealth2 = mypokemon.getCurrentHP() + item.getHeal();
        double hpProgress2 = newHealth2 / (double) mypokemon.getMaxHP();
        System.out.println("My Hp before attack: " + mypokemon.getCurrentHP() + "Item Str: " + item.getHeal());
        System.out.println("My Hp after attack: " + mypokemon.getCurrentHP() + "Calculated Hp after attack" + newHealth2);


        if (hpProgress2 < 0) {
            hpProgress2 = 0;
        } else if (hpProgress2 > 1) {
            hpProgress2 = 1;
        }

        this.healthPlayer.setProgress(hpProgress2);


        System.out.println("Opponent used " + item.getName());
        int heathOpponent = opppokemon.getCurrentHP();
        int newHealth = opppokemon.getCurrentHP() + item.getHeal();
        double hpProgress = newHealth / (double) opppokemon.getMaxHP();
        System.out.println("My Hp before attack: " + opppokemon.getCurrentHP() + "Item Str: " + item.getHeal());
        System.out.println("My Hp after attack: " + opppokemon.getCurrentHP() + "Calculated Hp after attack" + newHealth);

        if (hpProgress < 0) {
            hpProgress = 0;
        } else if (hpProgress > 1) {
            hpProgress = 1;
        }

        this.healthOpponent.setProgress(hpProgress);
    }

    @FXML
    private void test() {
        System.out.println("test");
    }

    @FXML
    private void swappokemon(int number) {
        Pokemon pokemon = mypokemon;
        switch (number) {
            case 1:
                pokemon = myTeam.getPokemon1();
                break;
            case 2:
                pokemon = myTeam.getPokemon2();
                break;
            case 3:
                pokemon = myTeam.getPokemon3();
                break;
            case 4:
                System.out.println("Please select an existing Pokémon");
                break;
            case 5:
                System.out.println("Please select an existing Pokémon");
                break;
            case 6:
                System.out.println("Please select an existing Pokémon");
                break;
            default:
                throw new RuntimeException();
        }
        String oldName = this.mypokemon.getName();
        this.mypokemon = pokemon;
        System.out.println(mypokemon.getName() + " was swapped with " + oldName);
        namemypokemon.setText(mypokemon.getName());
    }

    @FXML
    private void returntostart(ActionEvent event) throws IOException, URISyntaxException {

        Parent root = loader.load(getClass().getResource("/start.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    /*            case 4:
                pokemon = myTeam.getPokemon4();
                break;
            case 5:
                pokemon = myTeam.getPokemon5();
                break;
            case 6:
                pokemon = myTeam.getPokemon6();
                break;

     */

    @FXML
    private void sceneSwitch() {
        Parent root = null;
        try {
            root = loader.load(getClass().getResource("/end.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}

