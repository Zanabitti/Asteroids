package sample;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public abstract class Hahmo {

    private Polygon hahmo;
    private Point2D liike;

    public Hahmo(Polygon muoto, int x, int y){
        this.hahmo = muoto;
        this.hahmo.setTranslateY(y);
        this.hahmo.setTranslateX(x);
        this.liike = new Point2D(0,0);
    }

    public Polygon getHahmo() {
        return hahmo;
    }

    public void TurnLeft(int spd){
        this.hahmo.setRotate(this.hahmo.getRotate() - spd);
    }
    public void TurnRight(int spd){
        this.hahmo.setRotate(this.hahmo.getRotate() + spd);
    }
    public void Move(){
        this.hahmo.setTranslateX(this.hahmo.getTranslateX() + this.liike.getX());
        this.hahmo.setTranslateY(this.hahmo.getTranslateY() + this.liike.getY());
    }

    public void Accel(){
        double muutosX = Math.cos(Math.toRadians(this.hahmo.getRotate()))*0.05;
        double muutosY = Math.sin(Math.toRadians(this.hahmo.getRotate()))*0.05;

        this.liike = this.liike.add(muutosX,muutosY);
    }
}
