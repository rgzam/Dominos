package version1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> rowOne = new ArrayList<>();
        ArrayList<String> rowTwo = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Boneyard boneyard = new Boneyard();
        board board = new board();
        boneyard.addDominos();

        boolean madeMove = false;
        boolean shoulBreak = false;
        boolean placedLeft = false;
        boolean firtTurn = true;

        StringBuilder offset = new StringBuilder("  ");
        System.out.println("Boneyard has " + boneyard.getBoneyard().size() + " dominoes");


    }
}
