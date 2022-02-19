package Version2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;
import javafx.application.Application;
import version1.Domino;

public class GUI extends Application {
    public void imageView(Player player, HBox handBox, int i, Label selectLabel){
        Domino domino = player.accessPlayerHand().get(i);
        ImageView tempImagView = Version2.Domino.getImageView();

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
        for(int i = 0; i < player.accessPlayerHand().size(); i++){
            dominoImageView
        }
    }
    public static void main(String[] args) {
        launch(args);

    }
}
