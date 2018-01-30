import javax.swing.* ;
import java.awt.*;

public class PanelSaisieCouleur  extends JPanel  {
    public  PanelSaisieCouleur  () {
        // marges horizontales, verticales
        JLabel labelRouge = new JLabel("rouge") ;
        JTextField zoneDeMessageRouge = new JTextField(10) ;
        JLabel labelVert = new JLabel("vert") ;
        JTextField zoneDeMessageVert = new JTextField(10) ;
        JLabel labelBleu = new JLabel("bleu") ;
        JTextField zoneDeMessageBleu = new JTextField(10) ;
        
        JButton bouton = new JButton("Test") ;
        setBackground (new Color (100,67,98));
    }  // constructeur
}  // classe
