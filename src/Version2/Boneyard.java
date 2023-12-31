package Version2;

import version1.Domino;

import java.util.Collections;
import java.util.LinkedList;

public class Boneyard extends version1.Boneyard {
    private static final LinkedList<Domino> boneyard = new LinkedList<>();

    /**
     * Getter method
     * @return
     */
    public LinkedList<Domino> getBoneyard() {
        return boneyard;
    }

    /**
     * Populates the boneyard with 28 dominoes
     */
    public void addDominos(){
        for(int i = 0; i<= 6; i++) {
            for(int j = i; j<=6; j++) {
            Domino dom = new Domino(i,j);
            boneyard.add(dom);
            }

        }
        Collections.shuffle(boneyard);
    }

}
