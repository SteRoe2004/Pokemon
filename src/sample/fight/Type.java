package sample.fight;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public enum Type {
    WATER, FIRE, GRASS;

    Image image;

    Type() {
        FileInputStream fileInputStream;
        File f;
        try {
            switch (this.name().toLowerCase()) {
                case "fire":
                    f = new File("C:\\Users\\Stefan\\IdeaProjects\\Stefanmon\\res\\TypeFire.png");
                    break; // break beendet das switch-statement
                case "water":
                    f = new File("C:\\Users\\Stefan\\IdeaProjects\\Stefanmon\\res\\TypeWater.png");
                    break;
                case "grass":
                    f = new File("C:\\Users\\Stefan\\IdeaProjects\\Stefanmon\\res\\TypeGrass.png");
                    break;
                default:
                    throw new RuntimeException("Type failed");

            }
            fileInputStream = new FileInputStream(f);
            this.image = new Image(fileInputStream,
                    32, 32, true, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String getColour(){
        switch(this.name().toLowerCase()){
            case "fire":
                return "#ff4646";
            case "water":
                return "#2975e0";
            case "grass":
                return "#12c527";
            default:
                throw new RuntimeException("Colour of Type failed");
        }

    }

}

