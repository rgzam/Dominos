package version1;

import java.util.Collections;
import java.util.LinkedList;

public class Boneyard {
    private static final LinkedList<Domino> boneyard = new LinkedList<>();

    public LinkedList<Domino> getBoneyard() {
        return boneyard;
    }
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
