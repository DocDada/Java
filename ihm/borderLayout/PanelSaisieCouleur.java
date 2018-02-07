import javax.swing.* ;
import java.awt.event.*;
import java.awt.*;

public class PanelSaisieCouleur extends JPanel implements ActionListener {

    JLabel labelRouge = new JLabel("rouge") ;
    JTextField zoneDeMessageRouge = new JTextField(10) ;
    JLabel labelVert = new JLabel("vert") ;
    JTextField zoneDeMessageVert = new JTextField(10) ;
    JLabel labelBleu = new JLabel("bleu") ;
    JTextField zoneDeMessageBleu = new JTextField(10) ;
    JButton bouton = new JButton("Test") ;
    JLabel labelAModifier;
    PanelAffichageCouleur labelEnBas ;

    public PanelSaisieCouleur(JLabel parLabelAModifier, PanelAffichageCouleur parLabelEnBas) {
        add(zoneDeMessageRouge) ;
        add(zoneDeMessageVert) ;
        add(zoneDeMessageBleu) ;
        add(bouton) ;
        bouton.addActionListener(this) ;
        labelAModifier = parLabelAModifier;
        labelEnBas = parLabelEnBas ;
    }

    public void actionPerformed(ActionEvent parEvt) {
        if(parEvt.getSource() == bouton) {
            Color couleur = new Color(Integer.parseInt(zoneDeMessageRouge.getText()), Integer.parseInt(zoneDeMessageVert.getText()), Integer.parseInt(zoneDeMessageBleu.getText()) );
            //labelAModifier.setText(couleur.toString()) ;
            labelAModifier.setForeground(couleur) ;
            labelEnBas.setEtkDroite(couleur) ;
            // on affiche les composantes rgb
            labelEnBas.setEtkGauche(couleur) ;
            // on affiche un rectangle de la couleur donnee
        }
    }
}
