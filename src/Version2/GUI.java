/**
 * Ricardo Gonzales
 * The GUI class creates the interface and checks for a winner.
 * In order to play their will be a drop down menu for you to hit play
 * follow the instructions and you will see if you can beat the AI.
 */
package Version2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import version1.board;
import version1.Player;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.application.Application;


public class GUI extends Application {
    /**
     * Updates the rows on the gui placing the last domino on the right
     * @param rowBox
     * @param list
     */
    public void updateRow(HBox rowBox, ArrayList<ImageView> list) {
        ImageView image = list.get(list.size() - 1);
        rowBox.getChildren().add(image);
    }

    /**
     * Updates the rows on the gui placing the last domino on the left
     * @param rowBox
     * @param list
     */
    public void updateLeftRow(HBox rowBox, ArrayList<ImageView> list){
        ImageView image = list.get(list.size() - 1);
        rowBox.getChildren().add(0,image);
    }

    /**
     * Checks to see if the games has ended between the parameters of
     * the boneyard, player and computer.
     * @param boneyard
     * @param player
     * @param computer
     */
    public void checkGameEnd(Boneyard boneyard, Player player, Computer computer) {
        Alert gameOver = new Alert(Alert.AlertType.CONFIRMATION);
        String computerWin = "You lost";
        String playerWin = "You won! Congrulations.";
        if(boneyard.getBoneyard().isEmpty() || player.accessPlayerHand().isEmpty() ||
        computer.accessCopmuterHand().isEmpty()){
            int playerSum = player.getHand().sum();
            int computerSum = computer.getHand().sum();

            if(playerSum > computerSum) {
                gameOver.setContentText(computerWin);
            }else {
                gameOver.setContentText(playerWin);
            }
            gameOver.showAndWait();
            System.exit(0);
        }
    }

    /**
     * Gets the image of a domino and be able click on the domino
     * @param player
     * @param handBox
     * @param i
     * @param selectLabel
     */
    public void imageView(Player player, HBox handBox, int i, Label selectLabel){
        Domino domino = player.accessPlayerHand().get(i);
        ImageView tempImageView = domino.getImageView();
        tempImageView.setFitWidth(100);
        tempImageView.setPreserveRatio(true);
        handBox.getChildren().add(tempImageView);
        handBox.getChildren().get(i).setOnMouseClicked(event -> {
            player.getDomino(domino);
            selectLabel.setText("You've selected " + player.getDomino().toString());
        });
    }

    /**
     * Where the logic goes that creates the GUI.
     * Displays the labels, dominos, buttons, and drawing from the
     * boneyard.
     * @param stage
     */
    public void start(Stage stage){

        ArrayList<ImageView> rowImages = new ArrayList<>();
        BorderPane root = new BorderPane();
        Boneyard boneyard = new Boneyard();
        board board = new board();
        Player player = new Player(boneyard);
        Computer computer = new Computer(boneyard);
        boneyard.addDominos();
        Scene scene = new Scene(root, 1200,800);

        Label boneyardLabel = new Label("The boneyard has " + boneyard.getBoneyard().size() + " dominoes");
        Label handLabel = new Label("You have " + player.accessPlayerHand().size() + " dominoes");
        boneyardLabel.setFont(new Font(32));
        handLabel.setFont(new Font(32));


        HBox labelbox = new HBox();
        labelbox.setAlignment(Pos.TOP_CENTER);
        labelbox.setSpacing(10);
        labelbox.getChildren().addAll(boneyardLabel,handLabel);

        HBox handBox = new HBox();
        Label selectedLabel = new Label("You've Selected" + player.getDomino().toString());
        for(int i = 0; i < player.accessPlayerHand().size(); i++) {
            imageView(player,handBox,i, selectedLabel);
        }
        handBox.setAlignment(Pos.CENTER);
        handBox.setSpacing(5.0);

        VBox checkBox = new VBox();
        ToggleGroup rowChoice = new ToggleGroup();
        RadioButton leftButton = new RadioButton("Left");
        RadioButton rightButton = new RadioButton("Right");
        RadioButton flipButton = new RadioButton("Flip");
        leftButton.setToggleGroup(rowChoice);
        rightButton.setToggleGroup(rowChoice);
        rightButton.setSelected(true);
        checkBox.getChildren().addAll(leftButton,rightButton,flipButton);

        HBox rowBox = new HBox();
        HBox computerRowBox = new HBox();
        VBox rowsBox = new VBox();

        HBox btnBox = new HBox();

        Button placeBtn = new Button("place");
        placeBtn.setOnAction(event -> {
            checkGameEnd(boneyard,player,computer);
            RadioButton RowSide = (RadioButton) rowChoice.getSelectedToggle();
            String toggleGroupValue = RowSide.getText();
            handBox.getChildren().removeAll(player.getDomino().getImageView());


        });

        Button boneyardBtn = new Button("Draw from boneyard");
        boneyardBtn.setOnAction(event -> {
            checkGameEnd(boneyard,player,computer);
            player.drawBoneyard(boneyard);

            Domino newDomino = player.accessPlayerHand().get(player.accessPlayerHand().size()-1);
            newDomino.getImageView().setOnMouseClicked(event2 -> {
                player.getDomino(newDomino);
                selectedLabel.setText("You've selected" + player.getDomino().toString());
            });
            ImageView tempImageView = newDomino.getImageView();
            tempImageView.setFitWidth(100);
            tempImageView.setPreserveRatio(true);
            handBox.getChildren().add(tempImageView);
            boneyardLabel.setText("The boneyard has " + boneyard.getBoneyard().size() + "dominoes");
            handLabel.setText("You have" + player.accessPlayerHand().size() + "dominoes");
        });

        btnBox.getChildren().add(placeBtn);
        btnBox.getChildren().add(boneyardBtn);
        computerRowBox.setTranslateX(50);
        handBox.getChildren().add(0, btnBox);
        handBox.getChildren().add(1, checkBox);
        rowsBox.getChildren().addAll(rowBox, computerRowBox);
        root.setLeft(rowsBox);
        root.setRight(selectedLabel);
        root.setBottom(handBox);
        root.setTop(labelbox);

        stage.setScene(scene);
        stage.show();


    }

    /**
     * Launcher for the GUI
     * @param args
     */
    public static void main(String[] args) {
        launch(args);

    }
}
