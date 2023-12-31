package version1;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Domino> hand = new ArrayList<>(28);
    /**
     * Populates the hand with 7 dominoes
     * @param boneyard
     */
    public void populateHand(Boneyard boneyard){
        for(int i = 0; i<= 6; i++){
            hand.add(boneyard.getBoneyard().get(i));
        }
        boneyard.getBoneyard().removeAll(hand);
    }

    /**
     * Adds all the dominos in the hand and checks
     * for a win
     * @return
     */
    public int sum() {
        int totalSum = 0;
        for (Domino dom : hand) {
            int Front = dom.getFlip1();
            int Back = dom.getFlip2();
            int sum = Front+Back;
            totalSum += sum;
        }
        return totalSum;
    }
    /**
     * getter method
     * @return
     */
    public ArrayList<Domino> getHand(){
        return hand;
    }
}
