package version1;

import java.util.ArrayList;

public class Computer {
    private Hand hand = new Hand();
    private Boneyard boneyard = new Boneyard();
    private Boolean madeMove = false;
    /**
     * populates the hand with dominos from the boneyard
     * @param boneyard
     */
public Computer (Boneyard boneyard) {
    hand.populateHand(boneyard);
}
    /**
     * Draws a domino from the boneyard and then removes it
     * from the hand and the boneyard.
     * @param boneyard
     */
public void drawBoneyard(Boneyard boneyard) {
    Domino domino = boneyard.getBoneyard().get(0);
    boneyard.getBoneyard().remove(domino);
    hand.getHand().add(domino);
}
    /**
     * Places the domino and keeps track of the last placed domino.
     * Also searches for legals moves in order for the player to be able to draw
     * from the boneyard.
     * @param board
     */
public void placeDomino(board board) {
    Domino lastPlaced = board.getRow().get(board.getRow().size() - 1);
    do {
        for(Domino dom : hand.getHand()) {
            if (dom.getFlip1() == lastPlaced.getFlip1() || dom.getFlip1() == 0) {
                board.addRow(dom);
                hand.getHand().remove(dom);
                madeMove = true;
                System.out.println("Computer plays" + dom.toString());
                break;
            } else if(dom.getFlip2() == lastPlaced.getFlip2() || dom.getFlip2() == 0) {
                dom.flip();
                board.addRow(dom);
                hand.getHand().remove(dom);
                madeMove = true;
                System.out.println("Computer plays" + dom.toString());
                break;
            }
        }
        if (!madeMove) {
            drawBoneyard(boneyard);
            System.out.println("copmuter drew from boneyard");
        }
    } while (!madeMove);
    madeMove = false;
}
    /**
     * getter method
     * @return
     */
public ArrayList<Domino> accessCopmuterHand(){
    return hand.getHand();
}
    /**
     * getter method
     * @return
     */
public Hand getHand() {
    return hand;
}
}
