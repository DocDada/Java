javax.swing.JLabel ;
javax.swing.JPanel ;
javax.swing.JButton ;
java.awt.CardLayout ;
java.awt.ActionListener ;
java.awt.ActionEvent ;


public class PanelFilsDiaporama extends JPanel {
    public PanelFilsDiaporama() {
        // PANEL SUD //
        JPanel panelSud = new JPanel() ;
        //JButton precedent = new JButton("precedent") ;
        //JButton suivant = new JButton("suivant") ;
        JLabel etiquette = new JLabel() ;

        // PANEL CENTRE //
        JPanel panelCentre = new JPanel() ;
        panelCentre.setLayout(new CardLayout(5,5)) ;// a modifier


        // Tableaux PANEL SUD //
        // Intitules des boutons
        String intitulesBouttons[] = new String[10] ;
        // Boutons
        JButton boutons = new JButton[10] ;
        // Boucle d'instantiation et d'addition a panelSud
        for (int bouton = 0 ; bouton < 10 ; bouton++) {
            boutons[i] ;// a modifier
            panelSud.add(boutons) ;
        }

        // Tableaux PANEL CENTRE //
        // Intitules des etiquettes
        String intitulesEtiquettes = new String[10] ;
        // Etiquettes
        JLabel
        // Boucle d'instantiation et d'addition a panelSud


    }
}
