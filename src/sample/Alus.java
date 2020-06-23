package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import java.math.*;

public class Alus extends Hahmo{

    private ImageView PlayerPic;
    private double IvW;
    private double IvH;

    public Alus(int x, int y){
        super(new Polygon(
                0,20,
                15,20,
                15,0,
                0,0), x, y);
        Image PlayerImg = new Image("file:megaman.png");
        this.PlayerPic = new ImageView(PlayerImg);
        this.PlayerPic.setFitWidth(30);
        this.PlayerPic.setPreserveRatio(true);
        this.PlayerPic.setX(this.getHahmo().getTranslateX());
        this.PlayerPic.setY(this.getHahmo().getTranslateY());
        this.IvH = this.PlayerPic.boundsInParentProperty().get().getHeight();
        this.IvW = this.PlayerPic.boundsInParentProperty().get().getWidth();

    }

    @Override
    public void Move() {
        super.Move();
        this.PlayerPic.setX((this.getHahmo().getTranslateX()+7.5) - (this.IvW/2));
        this.PlayerPic.setY((this.getHahmo().getTranslateY()+10) - (this.IvH/2));
        this.PlayerPic.setRotate(this.getHahmo().getRotate());
    }

    public ImageView getImageView(){return this.PlayerPic;}

}
