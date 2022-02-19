package Version2;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Domino {
    private int Front, Back;
    private int id = 1;
    private  ImageView imageView;
    private Image image;

    public Domino(int Front, int Back){
    this.Front = Front;
    this.Back = Back;
    id++;
    String imageFilePath = "Resources/" + Front + "_" + Back + "@0.5x.png";
    this.image = new Image() {
        @Override
        public int getWidth(ImageObserver observer) {
            return 0;
        }

        @Override
        public int getHeight(ImageObserver observer) {
            return 0;
        }

        @Override
        public ImageProducer getSource() {
            return null;
        }

        @Override
        public Graphics getGraphics() {
            return null;
        }

        @Override
        public Object getProperty(String name, ImageObserver observer) {
            return null;
        }
    }
    }
    public void flip(){
    int ogFlip = Front;
    Front = Back;
    Back = ogFlip;
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
