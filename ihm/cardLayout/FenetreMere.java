package tp3 ;
import javax.swing.JFrame ;
import java.awt.Color ;
import java.awt.Insets ;

public class FenetreMere extends JFrame {
    public FenetreMere(String parTitre) {
        super(parTitre) ;
        PanelFilsDiaporama contentPane = new PanelFilsDiaporama();
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
        new FenetreMere("IHM - TP3") ;
    }

}
