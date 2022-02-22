package Version2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Domino {
    private int Front, Back;
    private  ImageView imageView;
    private Image image;

    /**
     * Assigns either front or back values to their corresponding images
     * @param Front
     * @param Back
     */
    public Domino(int Front, int Back){
    this.Front = Front;
    this.Back = Back;
   String imageFilePath = "res/" + Front + "_" + Back + "@0-0.png";
    this.image = new Image(imageFilePath, true);
    this.imageView = new ImageView(this.image);
    }

    public Domino() {

    }

    /**
     * After flipping the domino the constructor assigns the images
     * to the corresponding domino
     */
    public void flip(){
    int ogFlip = Front;
    Front = Back;
    Back = ogFlip;
   String imageFilePath = "res/" + Front + "_" + Back + "@0-0.png";
   this.image = new Image(imageFilePath,true);
   this.imageView = new ImageView(this.image);
   this.imageView.setFitWidth(100);
   this.imageView.setPreserveRatio(true);
    }

    /**
     * String representation of domino
     * @return
     */
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

    /**
     * getter method
     * @return
     */
    public ImageView getImageView(){
        return imageView;
    }
}
