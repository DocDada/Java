import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class FenetreMere extends JFrame{
    public FenetreMere(String parTitre){
        super(parTitre) ;
        // titre de la fenetre
        PanelFils contentPane = new PanelFils() ;
        setContentPane(contentPane) ;
        setBackground(new Color(200, 167, 198)) ;
        // défini la couleur du fond
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        // quitte si ferme la fenetre
        setSize(400, 200);
        // dimensions
        setVisible(true) ;
        // est visible
        setLocation(200, 300) ;
    }// FenetreMere

    public Insets getInsets(){
        return new Insets(20, 10, 10, 10) ;
        // marges (haut, gauche, bas, droite)
    }// getInsets

    public static void main(String []args){
        new FenetreMere(args[0]) ;
        // args[0] => premier argument passé
    }// main
}
