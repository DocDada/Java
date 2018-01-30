import javax.swing.* ;
import java.awt.*;

public class PanelFilsTestCouleurs  extends JPanel  {
    public  PanelFilsTestCouleurs  () {
        setLayout (new BorderLayout (20,20)) ;
        // marges horizontales, verticales
        PanelSaisieCouleur labelNord = new PanelSaisieCouleur () ;
        JLabel labelCentre = new JLabel("etiquette") ;
        // texte, et la zone du label (nord etc.)
        labelCentre.setOpaque (true);
        labelNord.setOpaque (true);
        // false : prend la couleur du background
        // true : met par defaut la zone en blanc par dessus le background
        labelCentre.setFont (new Font ("Verdana",Font.ITALIC,24));
        labelNord.setFont (new Font ("Arial",Font.BOLD,20));
        // font : nom police, style (gras, italic, normal), taille police)
        add (labelCentre, BorderLayout.CENTER);
        add (labelNord, BorderLayout.NORTH);
        // element, position
        setBackground (new Color (100,67,98));
    }  // constructeur
}  // classe
