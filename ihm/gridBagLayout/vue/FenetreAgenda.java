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
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        setBackground(new Color(200, 99, 63)) ;
        setSize(1500, 1000);
        setVisible(true);
    }

    public Insets getInsets() {
        return new Insets(100,100, 100, 100) ;
    }

    public static void main(String []args) {
        new FenetreAgenda("IHM - TP3") ;
    }

}
