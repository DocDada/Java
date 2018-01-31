import javax.swing.* ;
import java.awt.*;

public class PanelFilsTestCouleurs  extends JPanel  {
    public  PanelFilsTestCouleurs  () {
        setLayout (new BorderLayout (20,20)) ;
        // marges horizontales, verticales
        JLabel labelCentre = new JLabel("etiquette", JLabel.CENTER);
        // JLabel.CENTER == centrer le texte
        PanelSaisieCouleur labelNord = new PanelSaisieCouleur(labelCentre);
        labelCentre.setForeground( new Color(15, 15, 150)) ;
        // definit la couleur du texte
        labelCentre.setOpaque (true);
        labelNord.setOpaque (true);
        // false : prend la couleur du background
        // true : met par defaut la zone en blanc par dessus le background
        labelCentre.setFont (new Font ("Verdana",Font.ITALIC,54));
        labelNord.setFont (new Font ("Arial",Font.BOLD,20));
        // font : nom police, style (gras, italic, normal), taille police)
        add (labelCentre, BorderLayout.CENTER);
        add (labelNord, BorderLayout.NORTH);
        // element, position
        setBackground (new Color (100,67,98));
    }  // constructeur
}  // classe
