import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class FenetreMereTestCouleurs extends JFrame {
    public FenetreMereTestCouleurs(String parTitre) {
        super(parTitre) ;
        PanelFilsTestCouleurs contentPane = new PanelFilsTestCouleurs();
        setContentPane(contentPane) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        setSize(500, 500);
        setVisible(true);
        setLocation(300, 300);
    }

    public Insets getInsets() {
        return new Insets(100, 0, 0, 0) ;
    }

    public static void main(String []args) {
        new FenetreMereTestCouleurs("truc") ;
    }

}
