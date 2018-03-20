package vue;

import javax.swing.JFrame ;
import java.awt.Color ;
import java.awt.Insets ;

public class FenetreAgenda extends JFrame {
    private static final long serialVersionUID = 1L;

    public FenetreAgenda(String parTitre) {
        super(parTitre) ;
        PanelAgenda contentPane = new PanelAgenda();
        setContentPane(contentPane) ;
        contentPane.setBackground(new Color(200, 200, 200));
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        setBackground(new Color(200, 200, 200)) ;
        setSize(1200, 1000);
        setVisible(true);
        contentPane.panelF.getTextTitre().requestFocus();
    }

    public Insets getInsets() {
        return new Insets(1, 1, 1, 1) ;
    }

    public static void main(String []args) {
        new FenetreAgenda("IHM - TP4 - TP5") ;
    }

}