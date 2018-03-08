package vue;

import javax.swing.JFrame ;
import java.awt.Color ;
import java.awt.Insets ;

public class FenetreAgenda extends JFrame {
	private static final long serialVersionUID = 1L;

	public FenetreAgenda(String parTitre) {
        super(parTitre) ;
        PanelAgenda contentPane = new PanelAgenda(new PanelFormulaire());
        setContentPane(contentPane) ;
        contentPane.setBackground(new Color(200, 199, 163));
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        setBackground(new Color(200, 199, 163)) ;
        setSize(800, 1000);
        setVisible(true);
    }

    public Insets getInsets() {
        return new Insets(100,100, 100, 100) ;
    }

    public static void main(String []args) {
        new FenetreAgenda("IHM - TP3") ;
    }

}
