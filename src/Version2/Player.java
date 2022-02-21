package Version2;
import version1.Boneyard;
import version1.Domino;
import version1.board;

import java.util.ArrayList;

public class Player {
    private Version2.Hand hand = new Version2.Hand();
    private Version2.Domino getDomino = new Version2.Domino(0,0);
    private int turn =  1;

    public Player(version1.Boneyard boneyard) {
        hand.populateHand(boneyard);
    }

    public void placeDomino(board board, int dominoIndex, String flip, String sideChoice) {
        // not sure if I need yet
        version1.Domino domino = hand.getHand().get(dominoIndex);
        if (flip.equals("y")) {
            domino.flip();
        }
        if (turn == 1) {
            if (sideChoice.equals("1")) {
                board.addLeftRow(domino);
            } else {
                board.addRow(domino);
                turn++;
            }
            hand.getHand().remove(domino);
        } else {
            version1.Domino lastPlaced = board.getRow().get(board.getRow().size() - 1);
            if(sideChoice.equals("1")) {
                version1.Domino firstDomino = board.getRow().get(0);
                if(domino.getFlip2() == firstDomino.getFlip1() || domino.getFlip2() == 0 ||
                        firstDomino.getFlip1() == 0) {
                    board.addLeftRow(domino);
                    hand.getHand().remove(domino);
                } else {
                    throw new IllegalArgumentException("Invalid move, try again or draw from the boneyard");
                }
            } else {
                if (domino.getFlip1() == lastPlaced.getFlip2() || domino.getFlip2() == 0 || lastPlaced.getFlip2() == 0){
                    board.addRow(domino);
                    hand.getHand().remove(domino);

                } else {
                    throw new IllegalArgumentException("Invalid move, try again, or draw from the boneyard");
                }
            }
        }
    }
    public void drawBoneyard(Boneyard boneyard){
        version1.Domino domino = boneyard.getBoneyard().get(0);
        boneyard.getBoneyard().remove(domino);
        hand.getHand().add(domino);
    }

    public ArrayList<Domino> accessPlayerHand(){
        return hand.getHand();
    }

    public Hand getHand(){
        return hand;
    }

    public Version2.Domino getDomino(){
        return getDomino;
    }

    public void setSelectedDomino(Version2.Domino getDomino) {
        this.getDomino = getDomino;
    }

    public Object setSelectedDomino() {
        return getDomino;
    }
}
