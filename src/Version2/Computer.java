package Version2;

import version1.Boneyard;
import version1.Domino;
import version1.Hand;
import version1.board;

import java.util.ArrayList;

public class Computer {
    private Hand hand = new Hand();
    private version1.Boneyard boneyard = new version1.Boneyard();
    private Boolean madeMove = false;

public Computer(version1.Boneyard boneyard) {
    hand.populateHand(boneyard);
}

public void drawBoneyard(Boneyard boneyard) {
    Domino domino = boneyard.getBoneyard().get(0);
    boneyard.getBoneyard().remove(domino);
    hand.getHand().add(domino);
}

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
public ArrayList<Domino> accessCopmuterHand(){
    return hand.getHand();
}
public Hand getHand() {
    return hand;
}
}
