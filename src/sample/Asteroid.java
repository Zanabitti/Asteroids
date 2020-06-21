package sample;

import javafx.scene.shape.Polygon;

import java.util.Random;

public class Asteroid extends Hahmo{

    private double RotationMove;

    public Asteroid(int spawnx, int spawny){
        super(new MonikulmioTehdas().luoMonikulmio(),spawnx,spawny);
        Random rnd = new Random();
        super.getHahmo().setRotate(rnd.nextInt(360));

        for (int i = 0; i < rnd.nextInt(10); i++) {
            Accel();
        }
        this.RotationMove = 0.5 - rnd.nextDouble();
    }

    @Override
    public void Move() {
        super.Move();
        super.getHahmo().setRotate(this.RotationMove+super.getHahmo().getRotate());
    }
}
