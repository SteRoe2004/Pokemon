package sample.fight;

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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import sample.stats.AttackLib;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import static sample.Main.loader;
import static sample.Main.primaryStage;

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

    @FXML
    private ImageView ownImage;

    @FXML
    private ImageView oppImage;

    @FXML
    private TextArea chatWindow;


    public IntegerProperty observerOwn;
    public IntegerProperty observerOpp;

    @FXML
    private void initialize() {

        lib = new AttackLib();


        initBag();

        initTeam();

        initOberservers();

        initButtons();

        chatLog("");

        healthPlayer.setProgress(1);
        healthOpponent.setProgress(1);
        updateColours();

        namemypokemon.setText(mypokemon.getName());
        ownImage.setImage(mypokemon.render());
        nameopppokemon.setText(opppokemon.getName());
        oppImage.setImage(opppokemon.render());

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


        runButton.setVisible(false);
        runButton.setDisable(true);


    }


    public void mypokemonDead() throws IOException, URISyntaxException {
        chatLog("My " + mypokemon.getName() + " was defeated");
        //for (Pokemon p: myTeam.team) {
        //    if(p.getCurrentHP() > 0){
        //        oppExchange();
        //    }
        //}

    }

    public void opppokemonDead() throws IOException, URISyntaxException {
        chatLog("Enemy " + opppokemon.getName() + " was defeated");
        oppExchange();

    }


    private void initBag() {
        Item potion = new Item("Potion", 20);
        Item super_potion = new Item("Super Potion", 60);
        Item hyper_potion = new Item("Hyper Potion", 120);
        Item max_potion = new Item("MAX Potion", 500);
        this.mybag = new Bag(potion, super_potion, hyper_potion, max_potion);
    }

    private void initTeam() {
        Pokemon pokemon1 = new Pokemon("Venusaur", 125, 415, 415, Type.GRASS, "./res/Venusaur.png", AttackLib.getAttacks(Type.GRASS, 4));
        Pokemon pokemon2 = new Pokemon("Charizard", 150, 400, 400, Type.FIRE, "./res/charizard.png", AttackLib.getAttacks(Type.FIRE, 4));
        Pokemon pokemon3 = new Pokemon("Blastoise", 120, 410, 410, Type.WATER, "./res/Blastoise.png", AttackLib.getAttacks(Type.WATER, 4));
        this.myTeam = new Team(pokemon1, pokemon2, pokemon3);
        this.mypokemon = myTeam.getPokemon1();

        Pokemon pokemon4 = new Pokemon("Serperior", 140, 390, 390, Type.GRASS, "./res/serperior.png", AttackLib.getAttacks(Type.GRASS, 4));
        Pokemon pokemon5 = new Pokemon("Emboar", 100, 420, 420, Type.FIRE, "./res/Emboar.png", AttackLib.getAttacks(Type.FIRE, 4));
        Pokemon pokemon6 = new Pokemon("Samurott", 121, 405, 405, Type.WATER, "./res/Samurott.png", AttackLib.getAttacks(Type.WATER, 4));
        this.oppTeam = new Team(pokemon4, pokemon5, pokemon6);
        this.opppokemon = oppTeam.getPokemon1();

    }

    private void initOberservers() {
        observerOwn = new SimpleIntegerProperty(mypokemon.getCurrentHP());
        observerOpp = new SimpleIntegerProperty(opppokemon.getCurrentHP());

        observerOpp.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                chatLog("The opponent's Pok??mon currently has " + newValue.toString() + " HP");  //TODO Bei Bedarf entfernen sollte es st??ren (HP-Kommentar)
                updateColours();
                if ((int) newValue <= 0) {
                    try {
                        opppokemonDead();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        observerOwn.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                chatLog("Your Pok??mon currently has " + newValue.toString() + " HP");  //TODO Bei Bedarf entfernen sollte es st??ren (HP-Kommentar)
                if ((int) newValue <= 0) {
                    try {
                        mypokemonDead();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private void initButtons() {
        fightButton.setOnAction(event -> openAttackSelector());
        teamButton.setOnAction(event -> openPokemonSelector());
        bagButton.setOnAction(event -> openItemSelector());
        escapeButton.setOnAction(event -> openEscapeMenu());

        attackmove1.setOnAction(event -> attack(1));
        attackmove2.setOnAction(event -> attack(2));
        attackmove3.setOnAction(event -> attack(3));
        attackmove4.setOnAction(event -> attack(4));


        item1.setOnAction(event -> heal(1));
        item2.setOnAction(event -> heal(2));
        item3.setOnAction(event -> heal(3));
        item4.setOnAction(event -> heal(4));

        pokemon1.setOnAction(event -> swappokemon(1));
        pokemon2.setOnAction(event -> swappokemon(2));
        pokemon3.setOnAction(event -> swappokemon(3));
        pokemon4.setOnAction(event -> swappokemon(4));
        pokemon5.setOnAction(event -> swappokemon(5));
        pokemon6.setOnAction(event -> swappokemon(6));

        runButton.setOnAction(event -> {
            try {
                returntostart(event);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }


    @FXML
    private void openAttackSelector() {
        openAttacks();
        hideTeam();
        hideItems();
        hideEscape();

        attackmove1.setText(mypokemon.getAttack1().getName());
        attackmove2.setText(mypokemon.getAttack2().getName());
        attackmove3.setText(mypokemon.getAttack3().getName());
        attackmove4.setText(mypokemon.getAttack4().getName());

        attackmove1.setStyle("-fx-background-color: " + mypokemon.getAttack1().getType().getColour() + ";");
        attackmove2.setStyle("-fx-background-color: " + mypokemon.getAttack2().getType().getColour() + ";");
        attackmove3.setStyle("-fx-background-color: " + mypokemon.getAttack3().getType().getColour() + ";");
        attackmove4.setStyle("-fx-background-color: " + mypokemon.getAttack4().getType().getColour() + ";");

    }

    @FXML
    private void openPokemonSelector() {

        openTeam();
        hideAttacks();
        hideItems();
        hideEscape();

        pokemon1.setText(myTeam.getPokemon1().getName());
        pokemon2.setText(myTeam.getPokemon2().getName());
        pokemon3.setText(myTeam.getPokemon3().getName());

    }

    @FXML
    private void openItemSelector() {

        openItems();
        hideAttacks();
        hideTeam();
        hideEscape();

        item1.setText(mybag.getItem1().getName());
        item2.setText(mybag.getItem2().getName());
        item3.setText(mybag.getItem3().getName());
        item4.setText(mybag.getItem4().getName());

    }

    @FXML
    private void openEscapeMenu() {

        openEscape();
        hideAttacks();
        hideTeam();
        hideItems();

    }

    @FXML
    public void oppExchange() {
        Pokemon x = oppTeam.getnextPokemonwithHP();
        if (x != null) {
            opppokemon = x;
            nameopppokemon.setText(opppokemon.getName());
            oppImage.setImage(opppokemon.render());
            healthOpponent.setProgress(1);
        } else {
            try {
                gameOver(true);
                chatLog("You won!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void hideAttacks() {
        attackmove1.setVisible(false);
        attackmove1.setDisable(true);
        attackmove2.setVisible(false);
        attackmove2.setDisable(true);
        attackmove3.setVisible(false);
        attackmove3.setDisable(true);
        attackmove4.setVisible(false);
        attackmove4.setDisable(true);
    }

    private void hideTeam() {
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
    }

    private void hideItems() {
        item1.setDisable(true);
        item2.setDisable(true);
        item3.setDisable(true);
        item4.setDisable(true);
        item1.setVisible(false);
        item2.setVisible(false);
        item3.setVisible(false);
        item4.setVisible(false);
    }

    private void hideEscape() {
        runButton.setVisible(false);
        runButton.setDisable(true);
    }

    private void openAttacks() {
        attackmove1.setVisible(true);
        attackmove1.setDisable(false);
        attackmove2.setVisible(true);
        attackmove2.setDisable(false);
        attackmove3.setVisible(true);
        attackmove3.setDisable(false);
        attackmove4.setVisible(true);
        attackmove4.setDisable(false);

        vBoxFight.setDisable(false);
        vBoxTeam.setDisable(true);
        vBoxBag.setDisable(true);
        vBoxEscape.setDisable(true);
    }

    private void openTeam() {
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

        vBoxFight.setDisable(true);
        vBoxTeam.setDisable(false);
        vBoxBag.setDisable(true);
        vBoxEscape.setDisable(true);
    }

    private void openItems() {

        item1.setDisable(false);
        item2.setDisable(false);
        item3.setDisable(false);
        item4.setDisable(false);
        item1.setVisible(true);
        item2.setVisible(true);
        item3.setVisible(true);
        item4.setVisible(true);

        vBoxFight.setDisable(true);
        vBoxTeam.setDisable(true);
        vBoxBag.setDisable(false);
        vBoxEscape.setDisable(true);
    }

    private void openEscape() {
        runButton.setVisible(true);
        runButton.setDisable(false);

        vBoxFight.setDisable(true);
        vBoxTeam.setDisable(true);
        vBoxBag.setDisable(true);
        vBoxEscape.setDisable(false);
    }

    private void handlePokemon() {
        if (opppokemon.getCurrentHP() <= 0) {
            opppokemon = oppTeam.getnextPokemonwithHP();
        }

        if (mypokemon.getCurrentHP() <= 0) {
            mypokemon = myTeam.getnextPokemonwithHP();
        }

        updateColours();


        try {
            if (oppTeam.getnextPokemonwithHP() == null) {
                gameOver(true);
            }
            if (myTeam.getnextPokemonwithHP() == null) {
                gameOver(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void attack(int number) {
        Attack attackMe = selectAttack(number, true);
        Attack attackOpp = selectAttack(number, false);

        randomheal();

        if (mypokemon.getSpeed() >= opppokemon.getSpeed()) {
            executeAttack(attackMe, true);
            executeAttack(attackOpp, false);
        } else {
            executeAttack(attackOpp, false);
            executeAttack(attackMe, true);
        }
        updateColours();
    }


    private void executeAttack(Attack attack, boolean forPlayer) {

        Pokemon pokemon;
        ProgressBar health;
        IntegerProperty observer;
        Pokemon attacker;

        if (forPlayer) {
            pokemon = opppokemon;
            health = healthOpponent;
            observer = observerOpp;
            attacker = mypokemon;
        } else {
            pokemon = mypokemon;
            health = healthPlayer;
            observer = observerOwn;
            attacker = opppokemon;

        }
        int damage = attack.getDamage();

        if (attacker.getType() == Type.FIRE && pokemon.getType() == Type.GRASS) {
            damage = damage * 2;
        }
        if (attacker.getType() == Type.WATER && pokemon.getType() == Type.FIRE) {
            damage = damage * 2;
        }
        if (attacker.getType() == Type.GRASS && pokemon.getType() == Type.WATER) {
            damage = damage * 2;
        }
        if (attacker.getType() == Type.FIRE && pokemon.getType() == Type.WATER) {
            damage = (int) (damage * 0.75);
        }
        if (attacker.getType() == Type.WATER && pokemon.getType() == Type.GRASS) {
            damage = (int) (damage * 0.75);
        }
        if (attacker.getType() == Type.GRASS && pokemon.getType() == Type.FIRE) {
            damage = (int) (damage * 0.75);
        }


        int newHealth = pokemon.getCurrentHP() - damage;
        double hpProgress = newHealth / (double) pokemon.getMaxHP();
        chatLog(attacker.getName() + " used " + attack.getName());

        pokemon.setCurrentHP(newHealth);

        hpProgress = validateProgress(hpProgress);

        health.setProgress(hpProgress);
        observer.setValue(pokemon.getCurrentHP());
        handlePokemon();
    }


    private double validateProgress(double hpProgress) {
        if (hpProgress < 0) {
            hpProgress = 0;
        }
        if (hpProgress > 1) {
            hpProgress = 1;
        }
        return hpProgress;


    }

    private void updateColours() {

        healthPlayer.setStyle("-fx-accent: #49e020;");
        if (healthPlayer.getProgress() < 0.5) {
            healthPlayer.setStyle("-fx-accent: #f6ba41;");
        } else if (healthPlayer.getProgress() < 0.2) {
            healthPlayer.setStyle("-fx-accent: #fd1b10;");
        }

        healthOpponent.setStyle("-fx-accent: #49e020;");
        if (healthOpponent.getProgress() < 0.5) {
            healthOpponent.setStyle("-fx-accent: #f6ba41;");
        } else if (healthOpponent.getProgress() < 0.2) {
            healthOpponent.setStyle("-fx-accent: #fd1b10;");
        }
    }


    private Attack selectAttack(int number, boolean forplayer) {
        Attack attack;
        Pokemon attacking;
        if (forplayer) {
            attacking = mypokemon;
        } else {
            attacking = opppokemon;
        }
        switch (number) {
            case 1:
                attack = attacking.getAttack1();
                break;
            case 2:
                attack = attacking.getAttack2();
                break;
            case 3:
                attack = attacking.getAttack3();
                break;
            case 4:
                attack = attacking.getAttack4();
                break;
            default:
                throw new RuntimeException();
        }
        return attack;
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

        executeheal(item, mypokemon);
        updateColours();


    }

    private void executeheal(Item item, Pokemon pokemon) {

        ProgressBar health;
        IntegerProperty observer;

        if (myTeam.team.contains(pokemon)) {
            health = healthPlayer;
            observer = observerOwn;
        } else {
            health = healthOpponent;
            observer = observerOpp;

        }

        chatLog("You used " + item.getName());
        int heathPlayer1 = mypokemon.getCurrentHP();
        int newHealth2 = mypokemon.getCurrentHP() + item.getHeal();
        double hpProgress2 = newHealth2 / (double) mypokemon.getMaxHP();
        this.healthPlayer.setProgress(hpProgress2);
        mypokemon.setCurrentHP(newHealth2);

        hpProgress2 = validateProgress(hpProgress2);
        health.setProgress(hpProgress2);
        observer.setValue(pokemon.getCurrentHP());
    }

    private void executehealOpp(Item item, Pokemon pokemon) {
        ProgressBar health;
        IntegerProperty observer;

        health = healthOpponent;
        observer = observerOpp;


        chatLog("Opponent used " + item.getName());
        int heathOpponent = opppokemon.getCurrentHP();
        int newHealth = opppokemon.getCurrentHP() + item.getHeal();
        double hpProgress = newHealth / (double) opppokemon.getMaxHP();
        this.healthOpponent.setProgress(hpProgress);
        opppokemon.setCurrentHP(newHealth);

        hpProgress = validateProgress(hpProgress);

    }

    @FXML
    private void test() {
        chatLog("test");
    }

    @FXML
    private void swappokemon(int number) {
        handlePokemon();

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
                chatLog("Please select an existing Pok??mon");
                break;
            case 5:
                chatLog("Please select an existing Pok??mon");
                break;
            case 6:
                chatLog("Please select an existing Pok??mon");
                break;
            default:
                throw new RuntimeException();
        }
        String oldName = this.mypokemon.getName();
        this.mypokemon = pokemon;
        chatLog(mypokemon.getName() + " was swapped with " + oldName);
        namemypokemon.setText(mypokemon.getName());
        ownImage.setImage(mypokemon.render());
        healthPlayer.setProgress(mypokemon.getCurrentHP());
        updateColours();
    }

    @FXML
    private void returntostart(ActionEvent event) throws IOException, URISyntaxException {

        Parent root = loader.load(getClass().getResource("/start.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
        chatLog("You escaped the fight!");
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
    private void gameOver(boolean win) throws IOException {
        Parent root;
        if (win) {
            root = loader.load(getClass().getResource("/endVictory.fxml"));
        } else {
            root = loader.load(getClass().getResource("/end.fxml"));
        }
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
    }


    @FXML
    private void chatLog(String chat) {
        chatWindow.appendText("\n" + chat);
    }

    private void randomheal() {
        if (Math.random() <= 0.1) {
            Item item;
            int number = new Random().nextInt(3) + 1;
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

            executehealOpp(item, opppokemon);
            updateColours();
        }
    }


}
