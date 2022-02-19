package Version2;

import version1.Boneyard;
import version1.Computer;
import version1.Domino;
import version1.board;
import version1.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> rowOne = new ArrayList<>();
        ArrayList<String> rowTwo = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        version1.Boneyard boneyard = new Boneyard();
        version1.board board = new board();
        boneyard.addDominos();
        Player player = new Player(boneyard);
        version1.Computer computer = new Computer(boneyard);

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
                            System.out.println("Left or right? (l/r)");
                            choice = scanner.next();
                            if (choice.equals("l")) {
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
                        continue;
                    case "q":
                        System.out.println("Quitting game, thanks for playing!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid selection, please try again");
                }
            }
            firtTurn = false;

            while(madeMove) {
                madeMove = false;
                Domino lastPlaced = board.getRow().get(board.getRow().size() - 1);
                if(placedLeft) {
                    lastPlaced = board.getRow().get(0);
                    rowOne.add(0, lastPlaced.toString());

                    offset.append("    ");
                    placedLeft = false;
                } else {
                    rowOne.add(lastPlaced.toString());
                }
                System.out.println("Computer turn");
                computer.placeDomino(board);
                System.out.println("Boneyard has " + boneyard.getBoneyard().size() + " Dominoes");
                lastPlaced = board.getRow().get(board.getRow().size() - 1);
                rowTwo.add(lastPlaced.toString());

                System.out.println(rowOne.toString());
                System.out.println(offset + rowTwo.toString());
            }
            if (boneyard.getBoneyard().isEmpty()) {
                break;
            }
        }while (!player.accessPlayerHand().isEmpty());
        int playerSum = player.getHand().sum();
        int computerSum = computer.getHand().sum();

        if(playerSum > computerSum) {
            System.out.println("You had more point, you lost sorry");
        } else {
            System.out.println("You win");
        }
        System.out.println("Game over!");
                }


    }

