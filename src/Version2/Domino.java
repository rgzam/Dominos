package Version2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Domino {
    private int Front, Back;
    private  ImageView imageView;
    private Image image;

    public Domino(int Front, int Back){
    this.Front = Front;
    this.Back = Back;
   String imageFilePath = "dominos/" + Front + "_" + Back + "@0.5x.png";
    this.image = new Image(imageFilePath, true);
    this.imageView = new ImageView(this.image);
    }

    public Domino() {

    }

    public void flip(){
    int ogFlip = Front;
    Front = Back;
    Back = ogFlip;
   String imageFilePath = "Resources/" + Front + "_" + Back + "@0.5x.png";
   this.image = new Image(imageFilePath,true);
   this.imageView = new ImageView(this.image);
   this.imageView.setFitWidth(100);
   this.imageView.setPreserveRatio(true);
    }
    public String toString(){
        return "[" + Front + "|" + Back + "]";
    }
    /**
     * Getter method
     * @return
     */
    public int getFlip1(){
        return Front;
    }

    /**
     * Getter method
     * @return
     */
    public int getFlip2(){
        return Back;
    }

    public ImageView getImageView(){
        return imageView;
    }
}
