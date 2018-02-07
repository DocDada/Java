import java.io.File ;
import javax.swing.JLabel ;
import javax.swing.JPanel ;
import javax.swing.JButton ;
import javax.swing.ImageIcon ;
import java.awt.CardLayout ;
import java.awt.BorderLayout ;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;


public class PanelFilsDiaporama extends JPanel implements ActionListener {
    final int NB_BOUTONS_PSUD = 4 ;
    final int NB_BOUTONS_PCENTRE = 7 ;
    JButton boutons[] = new JButton[NB_BOUTONS_PSUD] ;
    String intitulesBoutons[] = {"premier", "precedent", "suivant", "dernier"} ;
    // Intitules des etiquettes
    File repertoire = new File("images") ;// Ex 2
    String intitulesImages[] = repertoire.list() ;// Ex 2
    // Exerice 1 // String intitulesEtiquettes[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"} ;
    // Etiquettes
    JLabel etiquettes[] = new JLabel[NB_BOUTONS_PCENTRE] ;
    CardLayout gestionnaire = new CardLayout(5, 5) ;
    JPanel panelSud = new JPanel() ;
    JLabel pSudEtiquette = new JLabel() ;
    JPanel panelCentre = new JPanel() ;

    public PanelFilsDiaporama() {
        this.setLayout(new BorderLayout(5, 5)) ;

        panelCentre.setLayout(gestionnaire) ;// a modifier


        // PANEL SUD //
        // Boucle d'instantiation et d'addition a panelSud
        for (int bouton = 0 ; bouton < boutons.length ; bouton++) {
            boutons[bouton] = new JButton(intitulesBoutons[bouton]);
            boutons[bouton].addActionListener(this) ;
            panelSud.add(boutons[bouton], intitulesBoutons[bouton]) ;
        }
        panelSud.add(pSudEtiquette) ;

        // PANEL CENTRE //
        // Boucle d'instantiation et d'addition a panelSud
        /* EXERICE 1
        for (int etiquette = 0 ; etiquette < etiquettes.length ; etiquette++) {
            etiquettes[etiquette] = new JLabel(intitulesEtiquettes[etiquette]);
            panelCentre.add(etiquettes[etiquette], intitulesEtiquettes[etiquette]) ;
        }
        */
        for (int etiquette = 0 ; etiquette < intitulesImages.length ; etiquette++) {
            etiquettes[etiquette] = new JLabel(new ImageIcon("images"+File.separator+intitulesImages[etiquette]));
            panelCentre.add(etiquettes[etiquette], intitulesImages[etiquette]) ;
        }
        this.add(panelCentre, BorderLayout.CENTER) ;
        this.add(panelSud, BorderLayout.SOUTH) ;
    }

    public void actionPerformed(ActionEvent parEvt) {
        if (parEvt.getSource() == boutons[0])// premier
            gestionnaire.first(this.panelCentre) ;
        else if (parEvt.getSource() == boutons[1])// precedent
            gestionnaire.previous(this.panelCentre) ;
        else if (parEvt.getSource() == boutons[2])// suivant
            gestionnaire.next(this.panelCentre) ;
        else
            gestionnaire.last(this.panelCentre) ;// dernier
    }
}
