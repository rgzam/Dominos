package version1;
public class Domino {
    private int Front, Back;
    private int id = 1;

    public Domino(int Flip1, int Flip2){
    this.Front = Front;
    this.Back = Back;
    id++;
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
}
