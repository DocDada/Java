package tp10JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class ExempleDia extends Application {
    public void start(Stage stage) {
        // TITRE
        stage.setTitle("IHM - TP10 - JavaFX - LineChart");

        final CategoryAxis xAxis = new CategoryAxis();
        // CategoryAxis utilisé pour les mois : Janvier, Février ...
        final NumberAxis yAxis = new NumberAxis();
        // NumberAxis utilisé pour des données numériques (notes)

        xAxis.setLabel("Mois");
        // intitulé de l'axe des abscisses
        yAxis.setLabel("Notes/20");
        // intitulé de l'axe des ordonnées
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Notes d'un élève de DUT INFO");
        // titre du diagramme

        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
        // les différentes données/courbes
        series.setName("Mes notes de l'année 2017/2018");
        series2.setName("Mes notes de l'année 2016/2017");
        // titres donnés aux courbes

        series2.getData().add(new XYChart.Data<String, Number>("Janv", 10));
        series2.getData().add(new XYChart.Data<String, Number>("Févr", 15));
        series2.getData().add(new XYChart.Data<String, Number>("Mars", 14));
        series2.getData().add(new XYChart.Data<String, Number>("Avri", 18));
        series2.getData().add(new XYChart.Data<String, Number>("Mai", 15));
        series2.getData().add(new XYChart.Data<String, Number>("Juin", 10));
        series2.getData().add(new XYChart.Data<String, Number>("Juil", 0));
        series.getData().add(new XYChart.Data<String, Number>("Sept", 12));
        series.getData().add(new XYChart.Data<String, Number>("Octo", 13));
        series.getData().add(new XYChart.Data<String, Number>("Nove", 16));
        series.getData().add(new XYChart.Data<String, Number>("Déce", 19));
        // ajout de données aux deux courbes

        lineChart.setCreateSymbols(false);
        // enlève les symboles du diagramme (true par défaut)
        // xAxis.setSide(Side.TOP);
        // met l'axe des abscisses en haut
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