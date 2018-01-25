import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class FenetreMere extends JFrame{
    public FenetreMere(String parTitre){
        super(parTitre) ;
        PanelFils contentPane = new PanelFils() ;
        setContentPane(contentPane) ;
        setBackground(new Color(200, 167, 198)) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        setSize(400, 200);
        setVisible(true) ;
        setLocation(200, 300) ;
    }// FenetreMere

    // configure la marge exterieure
    public Insets getInsets(){
        return new Insets(80, 50, 50, 50) ;
    }

    public static void main(String []args){
        new FenetreMere(args[0]) ;
        // args[0] => premier argument passé
    }// main
}
