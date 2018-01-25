import javax.swing.* ;
import java.awt.event.* ;

public class PanelFils extends JPanel implements ActionListener {
    JTextField zoneDeSaisie = new JTextField("Entrez votre nom") ;
    // zone de saisie
    JButton bouton = new JButton("Envoi") ;
    // boutton
    JTextField zoneDeMessage = new JTextField(10) ;
    // zone d'affichage (10 : longueur de la zone)
    JLabel label = new JLabel("essai étiquette") ;
    //JTextArea zoneDeTexte = new JtexteArea(10, 30) ;
    //JRadioButton radioBouton = new JRadioButton("bouton radio") ;

    public PanelFils() {
        add(zoneDeSaisie) ;
        add(bouton) ;
        bouton.addActionListener(this) ;
        add(zoneDeMessage) ;
        //add(label) ;
        //add(zoneDeTexte) ;
        //add(radioBouton) ;
    }

    public void actionPerformed(ActionEvent parEvt) {
        // si on appuie sur le bouton
        if (parEvt.getSource()==bouton)
            zoneDeMessage.setText("Bonjour "+zoneDeSaisie.getText()) ;
        // on affiche Bonjour + notre saisie
    }// actionPerformed
}// PanelFils
