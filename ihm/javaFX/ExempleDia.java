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
        // CategoryAxis utilis� pour les mois : Janvier, F�vrier ...
        final NumberAxis yAxis = new NumberAxis();
        // NumberAxis utilis� pour des donn�es num�riques (notes)

        xAxis.setLabel("Mois");
        // intitul� de l'axe des abscisses
        yAxis.setLabel("Notes/20");
        // intitul� de l'axe des ordonn�es
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Notes d'un �l�ve de DUT INFO");
        // titre du diagramme

        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
        // les diff�rentes donn�es/courbes
        series.setName("Mes notes de l'ann�e 2017/2018");
        series2.setName("Mes notes de l'ann�e 2016/2017");
        // titres donn�s aux courbes

        series2.getData().add(new XYChart.Data<String, Number>("Janv", 10));
        series2.getData().add(new XYChart.Data<String, Number>("F�vr", 15));
        series2.getData().add(new XYChart.Data<String, Number>("Mars", 14));
        series2.getData().add(new XYChart.Data<String, Number>("Avri", 18));
        series2.getData().add(new XYChart.Data<String, Number>("Mai", 15));
        series2.getData().add(new XYChart.Data<String, Number>("Juin", 10));
        series2.getData().add(new XYChart.Data<String, Number>("Juil", 0));
        series.getData().add(new XYChart.Data<String, Number>("Sept", 12));
        series.getData().add(new XYChart.Data<String, Number>("Octo", 13));
        series.getData().add(new XYChart.Data<String, Number>("Nove", 16));
        series.getData().add(new XYChart.Data<String, Number>("D�ce", 19));
        // ajout de donn�es aux deux courbes

        lineChart.setCreateSymbols(false);
        // enl�ve les symboles du diagramme (true par d�faut)
        // xAxis.setSide(Side.TOP);
        // met l'axe des abscisses en haut
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series2);
        lineChart.getData().add(series);
        // l'ordre d'addition est IMPORTANT par rapport
        // � l'axe des abscisses
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}