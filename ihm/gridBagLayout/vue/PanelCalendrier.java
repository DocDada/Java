package vue ;
import java.util.Iterator;

import javax.swing.JLabel ;
import javax.swing.JPanel ;

import controleur.Controleur;
import modele.CalendrierDuMois;
import modele.Date;
import javax.swing.JButton ;
import java.awt.CardLayout ;
import java.awt.BorderLayout ;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;


public class PanelCalendrier extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	final int NB_BOUTONS_PSUD = 4 ;
    final int NB_BOUTONS_PCENTRE = 45 ;


    JButton boutons[] = new JButton[NB_BOUTONS_PSUD] ;
    String intitulesBoutons[] = {"<<", "<", ">", ">>"} ;
    // Intitules des etiquettes
    String jours[] = {"di", "lu", "ma", "me", "je", "ve", "sa"} ;
	String mois[] = {"janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "novembre", "octobre", "décembre"} ;
    int moisAffiche ;
    // Etiquettes
    JLabel etiquettes[] = new JLabel[NB_BOUTONS_PCENTRE] ;
    CardLayout gestionnaire = new CardLayout(5, 5) ;// jours du mois 1, 2 ...
    JPanel panelSud = new JPanel() ;// pour les boutons suivant, precedent etc.
    JLabel pSudEtiquette = new JLabel() ;// pour le mois
    JPanel panelCentre = new JPanel() ;// le calendrier
    CalendrierDuMois cal = new CalendrierDuMois(new Date().getChMois(), new Date().getChAnnee());
	private int anneeAffiche;
    
    public PanelCalendrier() {
        this.setLayout(new BorderLayout(0, 0)) ;

        panelCentre.setLayout(gestionnaire) ;


        // PANEL SUD //
        // Boucle d'instantiation et d'addition a panelSud
        for (int bouton = 0 ; bouton < boutons.length ; bouton++) {
            boutons[bouton] = new JButton(intitulesBoutons[bouton]);
            boutons[bouton].addActionListener(this) ;
            panelSud.add(boutons[bouton], intitulesBoutons[bouton]) ;
        }

        // PANEL CENTRE //
        /*Iterator<Date> iter = cal.getDates().iterator();
        int jour ;
        for (int etiquette = 0 ; etiquette < NB_BOUTONS_PCENTRE && iter.hasNext() ; etiquette++) {
        	jour = iter.next().getChJour() ;
            etiquettes[etiquette] = new JLabel(Integer.toString(jour));
            panelCentre.add(etiquettes[etiquette]) ;
        }*/
        moisAffiche = new Date().getChMois() ;
        pSudEtiquette.setText(Date.getChMoisString(moisAffiche)) ;
        panelSud.add(pSudEtiquette) ;
        // additions des panels panelSud et panelCentre
        //this.add(panelCentre, BorderLayout.CENTER) ;
        this.add(panelSud, BorderLayout.SOUTH) ;
    }



    


    public void actionPerformed(ActionEvent parEvt) {
        if (parEvt.getSource() == boutons[0]) {
            gestionnaire.first(this.panelCentre) ;
            moisAffiche = 0 ;
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche)) ;
        }
        else if (parEvt.getSource() == boutons[1]) {
            gestionnaire.previous(this.panelCentre) ;
            if (moisAffiche != 0)
            	moisAffiche-- ;
            else {
            	moisAffiche = 12 ;
            	anneeAffiche-- ;
            	setCal(new CalendrierDuMois(12, anneeAffiche));
            }
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche)) ;
        }
        else if (parEvt.getSource() == boutons[2]) {
            gestionnaire.next(this.panelCentre) ;
            moisAffiche++ ;
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche)) ;
        }
        else {
            gestionnaire.last(this.panelCentre) ;
            moisAffiche = 12 ;
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche)) ;
        }
    }



	public void setCal(CalendrierDuMois cal) {
		this.cal = cal;
	}






	public void enregistreEcouteur(Controleur controleur) {
		// TODO Auto-generated method stub
		
	}
}
