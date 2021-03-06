/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LemonadeDash extends Application {
    Pane cur_pane = new Pane();
    Scene scene;
    
    private STATE state = STATE.STORE;
    Button cont = new Button("Continue");
    
    StoreScreen store = new StoreScreen();
    RecipeScreen recipe = new RecipeScreen();
    
    public Pane initStore(){
        cont.setOnAction(e->{
            state = STATE.RECIPE;
            scene.setRoot(initRecipe());
        });
        
        return store.initScreen();
    }
    
    public Pane initRecipe(){
        return recipe.initScreen();
    }
    
    @Override
    public void start(Stage primaryStage) {
        cur_pane = initStore();
        cont.setTranslateX(350);
        cont.setTranslateY(350);
        cur_pane.getChildren().add(cont);
        
        scene = new Scene(cur_pane, 800, 600);
        primaryStage.setTitle("Lemonade Dash");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //use this to show the current state of the game
    public static enum STATE{
        START,
        SETUP,
        STORE,
        RECIPE,
        GAME,
        STATS,
        OVER,
        HIGHSCORES
    };
    
}