package sample;

import com.sun.javafx.css.StyleCache;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Pane ruutu = new Pane();
        ruutu.setPrefSize(600, 400);

        Map<KeyCode,Boolean> KeysDown = new HashMap<>();


        Alus player = new Alus(300,200);
        Asteroid blockko = new Asteroid();
        blockko.Accel();
        blockko.Accel();
        ruutu.getChildren().add(player.getHahmo());
        ruutu.getChildren().add(blockko.getHahmo());


        Scene scene = new Scene(ruutu);

        scene.setOnKeyPressed(event->{KeysDown.put(event.getCode(),true);});
        scene.setOnKeyReleased(event->{KeysDown.put(event.getCode(),false);});
        stage.setScene(scene);
        stage.setTitle("Asteröids");

        new AnimationTimer() {
            @Override
            public void handle(long now){
                if(KeysDown.getOrDefault(KeyCode.LEFT,false)) player.TurnLeft(5);
                if(KeysDown.getOrDefault(KeyCode.RIGHT,false)) player.TurnRight(5);
                if(KeysDown.getOrDefault(KeyCode.UP, false)) player.Accel();
                player.Move();
                blockko.Move();
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
