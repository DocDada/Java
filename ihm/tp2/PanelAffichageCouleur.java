import javax.swing.JLabel ;
import javax.swing.JPanel ;
import java.awt.Color ;
import java.awt.Dimension;

public class PanelAffichageCouleur extends JPanel {
    JLabel etkGauche = new JLabel() ;
    JLabel etkDroite = new JLabel() ;
    public PanelAffichageCouleur(Color parCouleur) {
        etkGauche.setText(parCouleur.toString()) ;
        etkGauche.setForeground(parCouleur) ;
        etkDroite.setMinimumSize(new Dimension(50,70)) ;
        etkDroite.setPreferredSize(new Dimension(50,50)) ;
        etkDroite.setMaximumSize(new Dimension(60,60)) ;
        add(etkGauche) ;
        add(etkDroite) ;
        etkDroite.setBackground(parCouleur) ;
        etkDroite.setOpaque(true) ;
    }

    public void setEtkDroite(Color parCouleur) {
        this.etkDroite.setBackground(parCouleur) ;
    }

    public void setEtkGauche(Color parCouleur) {
        this.etkGauche.setText(parCouleur.toString()) ;
        this.etkGauche.setForeground(parCouleur) ;
    }
}
