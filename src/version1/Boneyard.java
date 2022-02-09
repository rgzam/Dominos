package version1;

import java.util.LinkedList;

public class Boneyard {
    private static final LinkedList<Domino> boneyard = new LinkedList<>();

    public LinkedList<Domino> getBoneyard() {
        return boneyard;
    }
}
