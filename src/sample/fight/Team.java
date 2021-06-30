package sample.fight;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import sample.fight.FightController;

import static sample.Main.loader;
import static sample.Main.primaryStage;

public class Team {

    public List<Pokemon> team = new ArrayList<>();

   private Pokemon pokemon1;
   private Pokemon pokemon2;
   private Pokemon pokemon3;
   //private Pokemon pokemon4;
   //private Pokemon pokemon5;
   //private Pokemon pokemon6;

   public Team(Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3){
       setPokemon1 (pokemon1);
       setPokemon2 (pokemon2);
       setPokemon3 (pokemon3);
       team.add(this.pokemon1);
       team.add(this.pokemon2);
       team.add(this.pokemon3);

   }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public Pokemon getPokemon3() {
        return pokemon3;
    }

   // public Pokemon getPokemon4() {
   //     return pokemon4;
   // }
//
   // public Pokemon getPokemon5() {
   //     return pokemon5;
   // }
//
   // public Pokemon getPokemon6() {
   //     return pokemon6;
   // }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public void setPokemon3(Pokemon pokemon3) {
        this.pokemon3 = pokemon3;
    }

   // public void setPokemon4(Pokemon pokemon4) {
   //     this.pokemon4 = pokemon4;
   // }
//
   // public void setPokemon5(Pokemon pokemon5) {
   //     this.pokemon5 = pokemon5;
   // }
//
   // public void setPokemon6(Pokemon pokemon6) {
   //     this.pokemon6 = pokemon6;
   // }

    public Pokemon getfirstPokemonwithHP() {
        for (Pokemon p : team) {
            if (p.getCurrentHP() >= 0) {
                return p;
            }
        }
        return null;
   }
}
