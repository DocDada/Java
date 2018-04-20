package tp10JavaFX;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class PanelContentPane extends JPanel implements ActionListener {

    private static final long serialVersionUID = -6869464466313959593L;
    Chart chart;
    private JButton modifierTitre ;

    public PanelContentPane() {
        modifierTitre = new JButton("Modifier le titre du diagramme");
        modifierTitre.addActionListener(this);
        final JFXPanel jfxPanel = new JFXPanel();
        this.add(jfxPanel);
        Platform.runLater(new Runnable() {
            public void run() {
                initFX(jfxPanel);
            }
        });
        this.add(modifierTitre);
    }

    public void initFX(JFXPanel jfxPanel) {
        Group root = new Group();
        chart = initChart();
        chart.setLayoutX(80);
        root.getChildren().add(chart);
        Scene scene = new Scene(root, 700, 500, Color.CORNSILK);
        jfxPanel.setScene(scene);
    }

    public static Chart initChart() {
        // retourne un diagramme
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
        lineChart.getData().add(series2);
        lineChart.getData().add(series);
        return lineChart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==modifierTitre)
            chart.setTitle(JOptionPane.showInputDialog(null, "Entrer un nouveau titre", "TITRE", JOptionPane.INFORMATION_MESSAGE));
    }
}