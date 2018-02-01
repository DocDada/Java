import javax.swing.JLabel ;
import javax.swing.JPanel ;
import java.awt.BorderLayout ;
import java.awt.Color ;
import java.awt.Font ;
import java.awt.Color ;

public class PanelFilsTestCouleurs extends JPanel {
    public  PanelFilsTestCouleurs (String parEtiquette, Color parEtk) {
        setLayout (new BorderLayout (20,20)) ;
        // marges horizontales, verticales
        JLabel labelCentre = new JLabel(parEtiquette, JLabel.CENTER);
        // JLabel.CENTER == centrer le texte

        PanelSaisieCouleur labelNord = new PanelSaisieCouleur(labelCentre);
        labelCentre.setForeground(parEtk) ;
        // definit la couleur du texte

        PanelAffichageCouleur labelSud = new PanelAffichageCouleur(parEtk) ;

        labelCentre.setOpaque (true);
        labelNord.setOpaque (true);
        labelSud.setOpaque(true) ;
        // false : prend la couleur du background
        // true : met par defaut la zone en blanc par dessus le background

        labelCentre.setFont (new Font ("Verdana",Font.ITALIC,54));
        labelNord.setFont (new Font ("Arial",Font.BOLD,20));
        labelSud.setFont(new Font("Arial", Font.PLAIN, 30)) ;
        // font : nom police, style (gras, italic, normal), taille police)

        add (labelCentre, BorderLayout.CENTER);
        add (labelNord, BorderLayout.NORTH);
        add(labelSud, BorderLayout.SOUTH) ;
        // element, position

        setBackground (new Color (100,67,98));
    }  // constructeur


}  // classe
