import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class FenetreMere extends JFrame {
    public FenetreMere(String parTitre) {
        super(parTitre) ;
        PanelFilsTreizeLabels contentPane = new PanelFilsTreizeLabels();
        setContentPane(contentPane) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        //setBackground(new Color(200, 99, 63)) ;
        setSize(500, 500);
        setVisible(true);
        setLocation(300, 300);
    }

    public Insets getInsets() {
        return new Insets(60, 0, 0, 0) ;
    }

    public static void main(String []args) {
        new FenetreMere("truc") ;
    }

}
