package vue;

import javax.swing.JFrame;
import java.awt.Color;
import java.io.Serializable;

public class FenetreAgenda extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;

    public FenetreAgenda(String parTitre) {
        super(parTitre);
        PanelAgenda contentPane = new PanelAgenda();
        setContentPane(contentPane);
        contentPane.setBackground(new Color(33, 63, 59));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(33, 63, 59));
        setSize(1500, 500);
        setVisible(true);
        contentPane.getPanelF().getTextTitre().requestFocus();
    }

    public static void main(String[] args) {
        new FenetreAgenda("IHM - TP4 - TP5 - TP6");
    }// main()

}// FenetreAgenda