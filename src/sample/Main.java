package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    public static FXMLLoader loader;
    public static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{

        initLoader(primaryStage);
        Parent root = loader.load(getClass().getResource("/start.fxml"));
        primaryStage.setTitle("Pokémon");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public  void initLoader(Stage p){
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getResource("../"));
        this.primaryStage=  p;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
