package sample;

import com.sun.javafx.css.StyleCache;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.geometry.Point2D;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.animation.AnimationTimer;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.util.List;

public class Main extends Application {

    public static int LEVEYS = 600;
    public static int KORKEUS = 500;

    @Override
    public void start(Stage stage) throws Exception {
        Pane ruutu = new Pane();
        ruutu.setPrefSize(LEVEYS, KORKEUS);

        Map<KeyCode,Boolean> KeysDown = new HashMap<>();

        Alus player = new Alus(LEVEYS/2,KORKEUS/2);


        List<Asteroid> AstList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random rnd = new Random();
            int rndx = rnd.nextInt(LEVEYS);
            while (rndx > LEVEYS*0.35 && rndx < LEVEYS*0.65){
                rndx = rnd.nextInt(LEVEYS);
            }
            int rndy = rnd.nextInt(KORKEUS);
            while (rndy > KORKEUS*0.35 && rndy < KORKEUS*0.65){
                rndy = rnd.nextInt(KORKEUS);
            }
            Asteroid ast = new Asteroid(rndx,rndy);//(rnd.nextInt(LEVEYS), rnd.nextInt(KORKEUS));
            ast.getHahmo().setStyle("-fx-fill:transparent;");
            AstList.add(ast);
        }
        player.getHahmo().setStyle("-fx-fill:transparent;");
        ruutu.getChildren().add(player.getHahmo());
        ruutu.getChildren().add(player.getImageView());
        AstList.forEach(ast -> {
            ruutu.getChildren().add(ast.getHahmo());
            ruutu.getChildren().add(ast.getImageview());
        });


        Scene scene = new Scene(ruutu);
        scene.setFill(new ImagePattern(new Image("file:spcback.jpg")));
        scene.setOnKeyPressed(event->{KeysDown.put(event.getCode(),true);});
        scene.setOnKeyReleased(event->{KeysDown.put(event.getCode(),false);});
        stage.setScene(scene);
        stage.setTitle("Asteröids");

        new AnimationTimer() {
            @Override
            public void handle(long now){

                //if(player.Collided(ast)) {
                //    player.LiikeRev();

                if(KeysDown.getOrDefault(KeyCode.LEFT,false)) player.TurnLeft(5);
                if(KeysDown.getOrDefault(KeyCode.RIGHT,false)) player.TurnRight(5);
                if(KeysDown.getOrDefault(KeyCode.UP, false)) player.Accel();
                AstList.forEach(ast -> {
                    if(player.Collided(ast)) player.LiikeRev();
                    ast.Move();
                });
                player.Move();
            }
        }.start();

        stage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
