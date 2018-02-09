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

    private int chIndice = 0 ;

    JButton boutons[] = new JButton[NB_BOUTONS_PSUD] ;
    String intitulesBoutons[] = {"premier", "precedent", "suivant", "dernier"} ;
    // Intitules des etiquettes
    File repertoire = new File("images") ;// Ex 2
    String intitulesImages[] = repertoire.list() ;// Ex 2
    // String intitulesEtiquettes[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"} ;// Ex1

    // Etiquettes
    JLabel etiquettes[] = new JLabel[NB_BOUTONS_PCENTRE] ;
    CardLayout gestionnaire = new CardLayout(5, 5) ;// necessaire pour la gestion des evenements
    JPanel panelSud = new JPanel() ;
    JLabel pSudEtiquette = new JLabel() ;
    JPanel panelCentre = new JPanel() ;

    public PanelFilsDiaporama() {
        this.setLayout(new BorderLayout(5, 5)) ;

        panelCentre.setLayout(gestionnaire) ;


        // PANEL SUD //
        // Boucle d'instantiation et d'addition a panelSud
        for (int bouton = 0 ; bouton < boutons.length ; bouton++) {
            boutons[bouton] = new JButton(intitulesBoutons[bouton]);
            boutons[bouton].addActionListener(this) ;
            panelSud.add(boutons[bouton], intitulesBoutons[bouton]) ;
        }

        // PANEL CENTRE //
        // Boucle d'instantiation et d'addition a paneCentre
        /* EXERCICE 1
        for (int etiquette = 0 ; etiquette < etiquettes.length ; etiquette++) {
            etiquettes[etiquette] = new JLabel(intitulesEtiquettes[etiquette]);
            panelCentre.add(etiquettes[etiquette], intitulesEtiquettes[etiquette]) ;
        }
        */
        for (int etiquette = 0 ; etiquette < intitulesImages.length ; etiquette++) {
            // instantiation des images
            etiquettes[etiquette] = new JLabel(new ImageIcon("images"+File.separator+intitulesImages[etiquette]));
            panelCentre.add(etiquettes[etiquette], intitulesImages[etiquette]) ;
            // addition des images au PanelCentre
        }
        // initialisation et addition de l'etiquette affichant le nom des fichiers
        pSudEtiquette.setText(intitulesImages[0]) ;
        panelSud.add(pSudEtiquette) ;
        // additions des panels panelSud et panelCentre
        this.add(panelCentre, BorderLayout.CENTER) ;
        this.add(panelSud, BorderLayout.SOUTH) ;
    }



    public void setTextParRapportALImage(char indice) {
        if (indice == 's') {
            if (chIndice == intitulesImages.length - 1)
                chIndice = 0 ;
            else
                chIndice++ ;
        }
        else if (indice == 'p') {
            if (chIndice == 0)
                chIndice = intitulesImages.length - 1 ;
            else
                chIndice-- ;
        }
        else if (indice == 'd')
            chIndice = intitulesImages.length - 1 ;
        else
            chIndice = 0 ;
        pSudEtiquette.setText(intitulesImages[chIndice]) ;
    }



    public void actionPerformed(ActionEvent parEvt) {
        if (parEvt.getSource() == boutons[0]) {
            // premiere image
            this.setTextParRapportALImage('d') ;
            gestionnaire.first(this.panelCentre) ;
        }
        else if (parEvt.getSource() == boutons[1]) {
            // image precedente
            this.setTextParRapportALImage('p') ;
            gestionnaire.previous(this.panelCentre) ;
        }
        else if (parEvt.getSource() == boutons[2]) {
            // image suivante
            this.setTextParRapportALImage('s') ;
            gestionnaire.next(this.panelCentre) ;
        }
        else {
            // derniere image
            this.setTextParRapportALImage('f') ;
            gestionnaire.last(this.panelCentre) ;
        }
    }
}
