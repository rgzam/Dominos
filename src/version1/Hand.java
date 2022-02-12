package version1;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Domino> hand = new ArrayList<>(28);
    public void populateHand(Boneyard boneyard){
        for(int i = 0; i<= 6; i++){
            hand.add(boneyard.getBoneyard().get(i));
        }
        boneyard.getBoneyard().removeAll(hand);
    }

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

    public ArrayList<Domino> getHand(){
        return hand;
    }
}
