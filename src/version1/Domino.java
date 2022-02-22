package version1;
public class Domino extends Version2.Domino {
    private int Front, Back;
    private int id = 1;
    /**
     * Assigns either front or back values to their corresponding images
     * @param Front
     * @param Back
     */
    public Domino(int Front, int Back){
        super();
        this.Front = Front;
    this.Back = Back;
    id++;
    }

    /**
     * The logic is once flipped their is an origanl side.
     */
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
}
