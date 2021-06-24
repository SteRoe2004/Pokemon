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

    private Pokemon mypokemon;
    private Pokemon opppokemon;

    private Bag mybag;

    private Team myteam;


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

        initPokemon1();
        initPokemon2();
        initPokemon3();
        initPokemon4();
        initPokemon5();
        initPokemon6();

        initBag();

        initTeam();


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

    private void initPokemon1(){
        Attack attack1 = new Attack("Ember", 40, Type.FIRE);
        Attack attack2 = new Attack("Flare Blitz", 120, Type.FIRE);
        Attack attack3 = new Attack("Heatwave", 95, Type.FIRE);
        Attack attack4 = new Attack("Inferno", 100, Type.FIRE);
        this.mypokemon = new Pokemon("Charizard", 150, 400, 400, Type.FIRE, attack1, attack2, attack3, attack4);
    }

    private void initPokemon2(){
        Attack attack1 = new Attack("Water Gun", 40, Type.WATER);
        Attack attack2 = new Attack("Hydro Pump", 110, Type.WATER);
        Attack attack3 = new Attack("Surf", 90, Type.WATER);
        Attack attack4 = new Attack("Dive", 80, Type.WATER);
        this.mypokemon = new Pokemon("Blastoise", 120, 410, 410, Type.WATER, attack1, attack2, attack3, attack4);

    }
    private void initPokemon3(){
        Attack attack1 = new Attack("Vine Whip", 45, Type.GRASS);
        Attack attack2 = new Attack("Petal Dance", 120, Type.GRASS);
        Attack attack3 = new Attack("Razor Leaf", 70, Type.GRASS);
        Attack attack4 = new Attack("Solar Beam", 120, Type.GRASS);
        this.mypokemon = new Pokemon("Venusaur", 125, 415, 415, Type.GRASS, attack1, attack2, attack3, attack4);

    }

    private void initPokemon4(){
        Attack attack1 = new Attack("Fire Blast", 125, Type.FIRE);
        Attack attack2 = new Attack("Heat Crash", 110, Type.FIRE);
        Attack attack3 = new Attack("Flame Charge", 60, Type.FIRE);
        Attack attack4 = new Attack("Flamethrower", 100, Type.FIRE);
        this.mypokemon = new Pokemon("Emboar", 100, 420, 420, Type.FIRE, attack1, attack2, attack3, attack4);

    }

    private void initPokemon5(){
        Attack attack1 = new Attack("Water Pulse", 45, Type.WATER);
        Attack attack2 = new Attack("Razor Shell", 90, Type.WATER);
        Attack attack3 = new Attack("Aquajet", 65, Type.WATER);
        Attack attack4 = new Attack("Aquatail", 100, Type.WATER);
        this.mypokemon = new Pokemon("Samurott", 121, 405, 405, Type.WATER, attack1, attack2, attack3, attack4);

    }

    private void initPokemon6(){
        Attack attack1 = new Attack("Leaf Tornado", 55, Type.GRASS);
        Attack attack2 = new Attack("Giga Drain", 75, Type.GRASS);
        Attack attack3 = new Attack("Leaf Blade", 90, Type.GRASS);
        Attack attack4 = new Attack("Leaf Storm", 135, Type.GRASS);
        this.mypokemon = new Pokemon("Serperior", 140, 390, 390, Type.GRASS, attack1, attack2, attack3, attack4);

    }

    private void initBag(){
        Item item1 = new Item ("Potion", 20);
        Item item2 = new Item ("Super Potion", 60);
        Item item3 = new Item ("Hyper Potion", 120);
        Item item4 = new Item ("MAX Potion", 500);
        this.mybag = new Bag(item1, item2, item3, item4);
    }

    private void initTeam(){
        Attack attack1 = new Attack("Vine Whip", 45, Type.GRASS);
        Attack attack2 = new Attack("Petal Dance", 120, Type.GRASS);
        Attack attack3 = new Attack("Razor Leaf", 70, Type.GRASS);
        Attack attack4 = new Attack("Solar Beam", 120, Type.GRASS);
        Attack attack1s = new Attack("Leaf Tornado", 55, Type.GRASS);
        Attack attack2s = new Attack("Giga Drain", 75, Type.GRASS);
        Attack attack3s = new Attack("Leaf Blade", 90, Type.GRASS);
        Attack attack4s = new Attack("Leaf Storm", 135, Type.GRASS);
        Attack attack1e = new Attack("Fire Blast", 125, Type.FIRE);
        Attack attack2e = new Attack("Heat Crash", 110, Type.FIRE);
        Attack attack3e = new Attack("Flame Charge", 60, Type.FIRE);
        Attack attack4e = new Attack("Flamethrower", 100, Type.FIRE);
        Attack attack1o = new Attack("Water Pulse", 45, Type.WATER);
        Attack attack2o = new Attack("Razor Shell", 90, Type.WATER);
        Attack attack3o = new Attack("Aquajet", 65, Type.WATER);
        Attack attack4o = new Attack("Aquatail", 100, Type.WATER);
        Attack attack1b = new Attack("Water Gun", 40, Type.WATER);
        Attack attack2b = new Attack("Hydro Pump", 110, Type.WATER);
        Attack attack3b = new Attack("Surf", 90, Type.WATER);
        Attack attack4b = new Attack("Dive", 80, Type.WATER);
        Attack attack1c = new Attack("Ember", 40, Type.FIRE);
        Attack attack2c = new Attack("Flare Blitz", 120, Type.FIRE);
        Attack attack3c = new Attack("Heatwave", 95, Type.FIRE);
        Attack attack4c = new Attack("Inferno", 100, Type.FIRE);
        Pokemon pokemon1 = new Pokemon("Venusaur", 125, 415, 415, Type.GRASS, attack1, attack2, attack3, attack4);
        Pokemon pokemon2 = new Pokemon("Charizard", 150, 400, 400, Type.FIRE, attack1c, attack2c, attack3c, attack4c);
        Pokemon pokemon3 = new Pokemon("Blastoise", 120, 410, 410, Type.WATER, attack1b, attack2b, attack3b, attack4b);
        Pokemon pokemon4 = new Pokemon("Serperior", 140, 390, 390, Type.GRASS, attack1s, attack2s,attack3s,attack4s);
        Pokemon pokemon5 = new Pokemon("Emboar", 100, 420, 420, Type.FIRE, attack1e, attack2e, attack3e,attack4e);
        Pokemon pokemon6 = new Pokemon ("Samurott", 121, 405, 405, Type.WATER, attack1o, attack2o,attack3o, attack4o);
        this.myteam = new Team(pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6);
    }


    @FXML
    private void openMenu(){
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

        attackmove1.setStyle("-fx-background-color: " + mypokemon.getAttack1().getType().getColour() +";");
        attackmove2.setStyle("-fx-background-color: " + mypokemon.getAttack2().getType().getColour() +";");
        attackmove3.setStyle("-fx-background-color: " + mypokemon.getAttack3().getType().getColour() +";");
        attackmove4.setStyle("-fx-background-color: " + mypokemon.getAttack4().getType().getColour() +";");

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

        pokemon1.setText(myteam.getPokemon1().getName());
        pokemon2.setText(myteam.getPokemon2().getName());
        pokemon3.setText(myteam.getPokemon3().getName());
        pokemon4.setText(myteam.getPokemon4().getName());
        pokemon5.setText(myteam.getPokemon5().getName());
        pokemon6.setText(myteam.getPokemon6().getName());
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
    private void attack(int number){
        Attack attack;
        switch(number){
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
            default: throw new RuntimeException();
        }
        System.out.println(mypokemon.getName() + " used attack " + attack.getName());
    }

    @FXML
    private void heal(int number){
        Item item;
        switch(number){
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
    }


    @FXML
    private void test(){
        System.out.println("test");
    }
    @FXML
    private void swappokemon(int number){
        Pokemon pokemon;
        switch(number){
            case 1:
                pokemon = myteam.getPokemon1();
                break;
            case 2:
                pokemon = myteam.getPokemon2();
                break;
            case 3:
                pokemon = myteam.getPokemon3();
                break;
            case 4:
                pokemon = myteam.getPokemon4();
                break;
            case 5:
                pokemon = myteam.getPokemon5();
                break;
            case 6:
                pokemon = myteam.getPokemon6();
                break;
            default:
                throw new RuntimeException();
        }
        String oldName = this.mypokemon.getName();
        this.mypokemon = pokemon;
        System.out.println(mypokemon.getName() + " was swapped with " + oldName);
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



