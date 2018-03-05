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
//import java.util.ArrayList ;

public class ExempleDia extends Application {
    public void start(Stage stage) {
        stage.setTitle("IHM - TP10 - JavaFX - LineChart");
        /*ArrayList maListe = new ArrayList();
        maListe.add("Janv");
        maListe.add("Févr");
        maListe.add("Mars");
        maListe.add("Avri");
        maListe.add("Mai");
        maListe.add("Juin");
        maListe.add("Juil");
        maListe.add("Aout");
        maListe.add("Sept");
        maListe.add("Nove");
        maListe.add("Octo");
        maListe.add("Dece");
        final CategoryAxis xAxis = new CategoryAxis(maListe) ;
        */
        final CategoryAxis xAxis = new CategoryAxis() ;
        final NumberAxis yAxis = new NumberAxis() ;
        // NumberAxis utilisé pour des données numériques (notes)
        xAxis.setLabel("Mois") ;
        // intitulé de l'axe des abscisses
        yAxis.setLabel("Notes/20") ;
        // intitulé de l'axe des ordonnées
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis, yAxis);
        lineChart.setTitle("Notes d'un élève de DUT INFO");
        // titre du diagramme
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        // les différentes données/courbes
        series.setName("Mes notes de l'année 2017/2018");
        series2.setName("Mes notes de l'année 2016/2017");
        // titres donnés aux courbes
        series2.getData().add(new XYChart.Data("Janv",10));
        series2.getData().add(new XYChart.Data("Févr",15));
        series2.getData().add(new XYChart.Data("Mars",14));
        series2.getData().add(new XYChart.Data("Avri",18));
        series2.getData().add(new XYChart.Data("Mai",15));
        series2.getData().add(new XYChart.Data("Juin",10));
        series2.getData().add(new XYChart.Data("Juil",0));
        series.getData().add(new XYChart.Data("Sept",12));
        series.getData().add(new XYChart.Data("Octo",13));
        series.getData().add(new XYChart.Data("Nove",16));
        series.getData().add(new XYChart.Data("Déce",19));
        // ajout de données
        lineChart.setCreateSymbols(false);
        // enlève les symboles du diagramme (true par défaut)
        //xAxis.setSide(Side.TOP);
        //met l'axe des abscisses en haut
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series2);
        lineChart.getData().add(series);
        // l'ordre d'addition est IMPORTANT par rapport
        // à l'axe des abscisses
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
