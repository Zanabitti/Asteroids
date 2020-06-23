package sample;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

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
    public Point2D getLiike() { return liike; }


    public void TurnLeft(int spd){
        this.hahmo.setRotate(this.hahmo.getRotate() - spd);
    }
    public void TurnRight(int spd){
        this.hahmo.setRotate(this.hahmo.getRotate() + spd);
    }
    public void Move(){
        if(!this.hahmo.getParent().getLayoutBounds().contains(this.hahmo.getBoundsInParent()) &&
                !this.hahmo.getParent().getLayoutBounds().intersects(this.hahmo.getBoundsInParent())) {
            if (this.hahmo.getTranslateX() < 0) this.hahmo.setTranslateX(Main.LEVEYS);
            if (this.hahmo.getTranslateX() > Main.LEVEYS) this.hahmo.setTranslateX(5-this.hahmo.boundsInParentProperty().get().getWidth());
            if (this.hahmo.getTranslateY() < 0) this.hahmo.setTranslateY(Main.KORKEUS);
            if (this.hahmo.getTranslateY() > Main.KORKEUS) this.hahmo.setTranslateY(5-this.hahmo.boundsInParentProperty().get().getHeight());
        }

        this.hahmo.setTranslateX(this.hahmo.getTranslateX() + this.liike.getX());
        this.hahmo.setTranslateY(this.hahmo.getTranslateY() + this.liike.getY());



    }

    public void Accel(){
        double muutosX = Math.cos(Math.toRadians(this.hahmo.getRotate()))*0.05;
        double muutosY = Math.sin(Math.toRadians(this.hahmo.getRotate()))*0.05;
        this.liike = this.liike.add(muutosX,muutosY);
    }
    public void Decel(){
        double muutosX = Math.cos(Math.toRadians(this.hahmo.getRotate()))*0.05;
        double muutosY = Math.sin(Math.toRadians(this.hahmo.getRotate()))*0.05;

        this.liike = this.liike.subtract(muutosX,muutosY);
    }
    public void LiikeRev(){
        double revX = this.liike.getX()*-1;
        double revY = this.liike.getY()*-1;

        this.liike = this.liike.multiply(-1);
    }
    public boolean Collided(Hahmo toinen){
        Shape CollArea = Shape.intersect(this.hahmo, toinen.getHahmo());
        return CollArea.getBoundsInLocal().getWidth() != -1;
    }
}
