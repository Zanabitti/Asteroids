package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

import java.util.Random;

public class Asteroid extends Hahmo{

    private double RotationMove;
    private ImageView AstPic;
    private double IvW;
    private double IvH;

    public Asteroid(int spawnx, int spawny){
        super(new MonikulmioTehdas().luoMonikulmio(),spawnx,spawny);
        Random rnd = new Random();
        super.getHahmo().setRotate(rnd.nextInt(360));

        for (int i = 0; i < rnd.nextInt(20); i++) {
            Accel();
        }
        this.RotationMove = 0.5 - rnd.nextDouble();

        Image ballimg = new Image("file:nic.png");
        this.AstPic = new ImageView(ballimg);
        this.AstPic.setStyle("-fx-opacity:1;");
        this.AstPic.setFitWidth(100);
        this.AstPic.setPreserveRatio(true);
        this.IvH = this.AstPic.boundsInParentProperty().get().getHeight();
        this.IvW = this.AstPic.boundsInParentProperty().get().getWidth();
    }
    public ImageView getImageview(){
        return this.AstPic;
    }
    @Override
    public void Move() {
        super.Move();
        super.getHahmo().setRotate(this.RotationMove+super.getHahmo().getRotate());

        this.AstPic.setX((this.getHahmo().getTranslateX()+25) - (this.IvW/2));
        this.AstPic.setY((this.getHahmo().getTranslateY()+50) - (this.IvH/2));
        this.AstPic.setRotate(this.getHahmo().getRotate());
    }
}
