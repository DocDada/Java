import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class FenetreMereTestCouleurs extends JFrame {
    public FenetreMereTestCouleurs(String parTitre, String parEtiquette, Color etk) {
        super(parTitre) ;
        PanelFilsTestCouleurs contentPane = new PanelFilsTestCouleurs(parEtiquette, etk);
        setContentPane(contentPane) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        setSize(800, 800);
        setVisible(true);
        setLocation(0, 0);
    }

    public Insets getInsets() {
        return new Insets(100, 0, 0, 0) ;
    }

    public static void main(String []args) {
        int r = Integer.parseInt(args[1]) ;
        int g = Integer.parseInt(args[2]) ;
        int b = Integer.parseInt(args[3]) ;
        Color etk = new Color(r, g, b) ;
        new FenetreMereTestCouleurs("A", args[0], etk);
    }

}
