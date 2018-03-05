
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestApplicationJavaFX extends Application {
    // la class principale dérive de Application
    public void start(Stage primaryStage) {
        primaryStage.setTitle("IHM - TP10 - JavaFX") ;
        // titre de la fenêtre
        Group root = new Group();
        Scene scene = new Scene(root, 300, 450, Color.RED);
        // Scene ; arguments :
        // groupe auquel la scène appartient
        // largeur, hauteur de la fenêtre
        // couleur de fond
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(280);
        // position du bouton dans la fenêtre
        btn.setText("Hello world");
        // texte du bouton

        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
                // si le bouton est enclenché
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
        Application.launch(args) ;
        // l'application est lancée à l'aide de
        // la méthode statique launch
    }
}
