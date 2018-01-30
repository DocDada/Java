import javax.swing.* ;
import java.awt.*;

public class PanelFilsTreizeLabels  extends JPanel  {
    public  PanelFilsTreizeLabels  () {
        setLayout (new BorderLayout (20,20)) ;
        // marges horizontales, verticales
        //JLabel labelCentre = new JLabel ("Zone Centre",JLabel.CENTER) ;
        JLabel labelNord = new JLabel ("Zone Nord",JLabel.CENTER) ;
        PanelFilsCinqLabels labelEst = new PanelFilsCinqLabels () ;
        PanelFilsCinqLabels labelCentre = new PanelFilsCinqLabels () ;
        //PanelFilsCinqLabels labelSud = new PanelFilsCinqLabels () ;
        //PanelFilsCinqLabels labelNord = new PanelFilsCinqLabels () ;
        JLabel labelSud = new JLabel ("Zone Sud",JLabel.CENTER) ;
        PanelFilsCinqLabels labelOuest = new PanelFilsCinqLabels () ;
        // texte, et la zone du label (nord etc.)
        labelCentre.setOpaque (true);
        labelNord.setOpaque (true);
        labelEst.setOpaque (true);
        labelSud.setOpaque (true);
        // false : prend la couleur du background
        // true : met par defaut la zone en blanc par dessus le background
        labelOuest.setOpaque (true);
        labelCentre.setFont (new Font ("Verdana",Font.ITALIC,24));
        labelNord.setFont (new Font ("Arial",Font.BOLD,20));
        labelEst.setFont (new Font ("Verdana",Font.ITALIC,16));
        labelSud.setFont (new Font ("Proxima nova",Font.PLAIN,22));
        labelOuest.setFont (new Font ("Times",Font.ITALIC,18));
        // font : nom police, style (gras, italic, normal), taille police)
        add (labelCentre, BorderLayout.CENTER);
        // element, position
        add (labelNord, BorderLayout.NORTH);
        add (labelEst, BorderLayout.EAST);
        add (labelSud, BorderLayout.SOUTH);
        add (labelOuest , BorderLayout.WEST);
        setBackground (new Color (100,67,98));
    }  // constructeur
}  // classe
