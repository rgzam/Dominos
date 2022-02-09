package version1;

import java.util.ArrayList;

public class board {
    private ArrayList<Domino> row = new ArrayList<>();

    /**
     * Adds a domino at the end of the row
     * @param domino
     */
    public void addRow(Domino domino){
        row.add(domino);

    }

    /**
     * Adds a domino at the beginning of the row
     * @param domino
     */
    public void addLeftRow (Domino domino){
        row.add(0, domino);
    }

    /**
     * Getter method
     * @return
     */
    public ArrayList<Domino> getRow(){
        return row;
    }
}
