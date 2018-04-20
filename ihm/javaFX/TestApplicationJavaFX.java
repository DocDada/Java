package tp10JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestApplicationJavaFX extends Application {
    // la class principale d�rive de Application
    public void start(Stage primaryStage) {
        primaryStage.setTitle("IHM - TP10 - JavaFX");
        // titre de la fen�tre
        Group root = new Group();
        Scene scene = new Scene(root, 450, 450, Color.RED);// horizontal, vertical, background
        // Scene ; arguments :
        // groupe auquel la sc�ne appartient
        // largeur, hauteur de la fen�tre
        // couleur de fond
        Button btn = new Button();
        btn.setLayoutX(200);
        btn.setLayoutY(200);
        // position du bouton dans la fen�tre
        btn.setText("Hello world");
        // texte du bouton

        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
                // si le bouton est enclench�
                // alors on affiche Hello World
                // dans le terminal
            }
        });

        root.getChildren().add(btn);
        // on ajoute au groupe le bouton
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        // l'application est lanc�e � l'aide de
        // la m�thode statique launch
    }
}