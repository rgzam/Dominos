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
        Player player = new Player(boneyard);

        boolean madeMove = false;
        boolean shouldBreak = false;
        boolean placedLeft = false;
        boolean firtTurn = true;

        StringBuilder offset = new StringBuilder("  ");
        System.out.println("Boneyard has " + boneyard.getBoneyard().size() + " dominoes");

        do {
            while (!madeMove) {
                if (shouldBreak) {
                    break;
                }
                System.out.println("Tray:" + player.accessPlayerHand());
                System.out.println("Human turn");
                System.out.println("[p] play Domino" + "\n[d] Draw from boneyard" + "\n[q] Quit");
                String playChoice = scanner.next();
                switch (playChoice) {
                    case "p":
                        System.out.println("Which domino would you like to place");
                        int dominoIndex = scanner.nextInt();
                        String choice = "r";

                        if (!firtTurn) {
                            System.out.println("Left or right? (1/r)");
                            choice = scanner.next();
                            if (choice.equals("1")) {
                                placedLeft = true;
                            }
                        }
                        System.out.println("Flip domino? (y/n)");
                        String flipChoice = scanner.next();

                        try {
                            player.placeDomino(board, dominoIndex, flipChoice, choice);
                            madeMove = true;
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid move, try again or draw from the boneyard.");
                            madeMove = false;
                            break;
                        }
                    case "d" :
                        player.drawBoneyard(boneyard);
                        System.out.println("GUI.Boneyard has " + boneyard.getBoneyard().size() + " dominoes");
                        if (boneyard.getBoneyard().isEmpty()) {
                            shouldBreak = true;
                        }
                    case "q":
                        System.out.println("Quitting game, thanks for playing!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid selection, please try again");
                }
            }
                }
        while(madeMove); {
            madeMove = false;
            Domino lastPlaced = board.getRow().get(board.getRow().size() - 1);
            }
        }

    }

