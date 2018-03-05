package javaFX ;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart ;
import javafx.scene.chart.NumberAxis ;
import javafx.scene.chart.CategoryAxis ;
import javafx.scene.chart.XYChart ;

public class PanelContentPane extends JPanel {
    Chart chart ;
    public PanelContentPane() {
        final JFXPanel jfxPanel = new JFXPAnel() ;
        this.add(jfxPanel) ;
        Platform.runLater(new Runnable() {
            public void run() {
                initFX(jfxPanel) ;
            }
        }) ;
    }

    public void initFX(JFXPanel jfxPanel) {
        Group root = new Group() ;
        chart = initChart() ;
        chart.setLayoutX(80) ;
        root.getChildren().add(chart) ;
        Scene scene = new Scene(root, 700, 500, Color.CORNSILK) ;
        jfxPanel.setScene(scene) ;
    }

    public static Chart initChart() {
        //
    }
}
