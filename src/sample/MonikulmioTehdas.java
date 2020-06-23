package sample;

import javafx.scene.shape.Polygon;
import java.util.Random;

public class MonikulmioTehdas {
    public Polygon luoMonikulmio(){
        Polygon monikulmio = new Polygon();
        monikulmio.getPoints().addAll(
          50.0,0.0,
          50.0,100.0,
            0.0,100.0,
            0.0,0.0
        );
        return monikulmio;
    }

    public Polygon luoMonikulmiox() {
        Random rnd = new Random();

        double koko = 30 + rnd.nextInt(60);

        Polygon monikulmio = new Polygon();
        double c1 = Math.cos(Math.PI * 2 / 5);
        double c2 = Math.cos(Math.PI / 5);
        double s1 = Math.sin(Math.PI * 2 / 5);
        double s2 = Math.sin(Math.PI * 4 / 5);

        monikulmio.getPoints().addAll(
                koko, 0.0,
                koko * c1, -1 * koko * s1,
                -1 * koko * c2, -1 * koko * s2,
                -1 * koko * c2, koko * s2,
                koko * c1, koko * s1);

        for (int i = 0; i < monikulmio.getPoints().size(); i++) {
            int muutos = rnd.nextInt(5) - 2;
            monikulmio.getPoints().set(i, monikulmio.getPoints().get(i) + muutos);
        }

        return monikulmio;
    }
}
