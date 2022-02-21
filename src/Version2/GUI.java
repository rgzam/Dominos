package Version2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.application.Application;


public class GUI extends Application {

    public void updateRow(HBox rowBox, ArrayList<ImageView> list) {
        ImageView image = list.get(list.size() - 1);
        rowBox.getChildren().add(image);
    }

    public void updateLeftRow(HBox rowBox, ArrayList<ImageView> list){
        ImageView image = list.get(list.size() - 1);
        rowBox.getChildren().add(0,image);
    }
    public void checkGameEnd(Boneyard boneyard, Player player, Computer computer) {
        Alert gameOver = new Alert(Alert.AlertType.CONFIRMATION);
        String computerWin = "You lost";
        String playerWin = "You won! Congrulations.";

        if(boneyard.getBoneyard().isEmpty()|| player.accessPlayerHand().isEmpty() ||
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
    public void imageView(Player player, HBox handBox, int i, Label selectLabel){
        Domino domino = player.accessPlayerHand().get(i);
        ImageView tempImageView = domino.getImageView();
        tempImageView.setFitWidth(100);
        tempImageView.setPreserveRatio(true);
        handBox.getChildren().add(tempImageView);
        handBox.getChildren().get(i).setOnMouseClicked(event -> {
            player.setSelectedDomino(domino);
            selectLabel.setText("You've selected " + player.setSelectedDomino().toString());
        });
    }
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
        stage.setScene(scene);
        stage.show();

        HBox labelbox = new HBox();
        labelbox.setAlignment(Pos.TOP_CENTER);
        labelbox.setSpacing(10);
        labelbox.getChildren().addAll(boneyardLabel,handLabel);

        HBox handBox = new HBox();
        Label selectedLabel = new Label("You've Selected" + player.getDomino().toString());

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


        computerRowBox.setTranslateX(50);
        handBox.getChildren().add(0, btnBox);
        handBox.getChildren().add(1, checkBox);
        rowsBox.getChildren().addAll(rowBox, computerRowBox);
        root.setLeft(rowsBox);
        root.setRight(selectedLabel);
        root.setBottom(handBox);
        root.setTop(labelbox);

    }
    public static void main(String[] args) {
        launch(args);

    }
}
