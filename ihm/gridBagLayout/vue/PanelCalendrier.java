package vue ;

import javax.swing.JLabel ;
import javax.swing.JPanel ;

import controleur.Controleur;
import modele.CalendrierDuMois;
import modele.Date;
import javax.swing.JButton ;
import java.awt.CardLayout ;
import java.awt.Color;
import java.awt.BorderLayout ;


public class PanelCalendrier extends JPanel {
	private static final long serialVersionUID = 1L;
	final int NB_BOUTONS_PSUD = 4 ;
    final int NB_BOUTONS_PCENTRE = 45 ;


    JButton boutons[] = new JButton[NB_BOUTONS_PSUD] ;
    String intitulesBoutons[] = {"<<", "<", ">", ">>"} ;
    // Intitules des etiquettes
	String mois[] = {"janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "novembre", "octobre", "décembre"} ;
    private int moisAffiche ;
    private int anneeAffiche;
    // Etiquettes
    JLabel etiquettes[] = new JLabel[NB_BOUTONS_PCENTRE] ;
    CardLayout gestionnaire = new CardLayout(5, 5) ;// jours du mois 1, 2 ...
    JPanel panelSud = new JPanel() ;// pour les boutons suivant, precedent etc.
    JLabel pSudEtiquette = new JLabel() ;// pour le mois
    JPanel panelCentre = new JPanel() ;// le calendrier
    PanelMois panelM ;
    CalendrierDuMois cal = new CalendrierDuMois(new Date().getChMois(), new Date().getChAnnee());
	
    
    public PanelCalendrier() {
        this.setLayout(new BorderLayout(0, 0)) ;
        panelCentre.setLayout(gestionnaire) ;

        
        // PANEL SUD //
        moisAffiche = new Date().getChMois() ;
        pSudEtiquette.setText(Date.getChMoisString(moisAffiche)) ;
        panelSud.add(pSudEtiquette) ;
        this.add(panelSud, BorderLayout.SOUTH) ;
        // Boucle d'instantiation et d'addition a panelSud
        // bouton pour parcourir le cardLayout
        for (int bouton = 0 ; bouton < boutons.length ; bouton++) {
            boutons[bouton] = new JButton(intitulesBoutons[bouton]);
            boutons[bouton].setActionCommand(intitulesBoutons[bouton]);
            panelSud.add(boutons[bouton], intitulesBoutons[bouton]) ;
        }

        // PANEL CENTRE //
        panelM = new PanelMois(moisAffiche) ;
        panelCentre.add(panelM) ;
        panelM.setOpaque(true);
        panelM.setBackground(new Color(200,200,200));
        add(panelCentre, BorderLayout.NORTH) ;
    }


    /*public void actionPerformed(ActionEvent parEvt) {
        if (parEvt.getSource() == boutons[0]) {
            gestionnaire.first(this.panelCentre) ;
            moisAffiche = 0 ;
            setCal(new CalendrierDuMois(moisAffiche, anneeAffiche));
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche+1)) ;
        }
        else if (parEvt.getSource() == boutons[1]) {
            gestionnaire.previous(this.panelCentre) ;
            if (moisAffiche <= 0) {
            	moisAffiche = 12 ;
            	anneeAffiche-- ;
            }
            moisAffiche-- ;
            setCal(new CalendrierDuMois(moisAffiche, anneeAffiche));
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche+1)) ;
        }
    	else if (parEvt.getSource() == boutons[2]) {
            gestionnaire.next(this.panelCentre) ;
            if (moisAffiche >= 11) {
            	moisAffiche = 0 ;
            	anneeAffiche++ ;
            }
            else
            	moisAffiche++ ;
            setCal(new CalendrierDuMois(moisAffiche, anneeAffiche));
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche+1)) ;
        }
        else {
            gestionnaire.last(this.panelCentre) ;
            moisAffiche = 11 ;
            setCal(new CalendrierDuMois(moisAffiche, anneeAffiche));
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche+1)) ;
        }
    }*/



	public void setCal(CalendrierDuMois cal) {
		this.cal = cal;
	}






	public String[] getMois() {
		return mois;
	}


	public void setMois(String[] mois) {
		this.mois = mois;
	}


	public int getMoisAffiche() {
		return moisAffiche;
	}


	public void setMoisAffiche(int moisAffiche) {
		this.moisAffiche = moisAffiche;
	}


	public int getAnneeAffiche() {
		return anneeAffiche;
	}


	public void setAnneeAffiche(int anneeAffiche) {
		this.anneeAffiche = anneeAffiche;
	}


	public JPanel getPanelSud() {
		return panelSud;
	}


	public void setPanelSud(JPanel panelSud) {
		this.panelSud = panelSud;
	}


	public JLabel getpSudEtiquette() {
		return pSudEtiquette;
	}


	public void setpSudEtiquette(JLabel pSudEtiquette) {
		this.pSudEtiquette = pSudEtiquette;
	}


	public JPanel getPanelCentre() {
		return panelCentre;
	}


	public void setPanelCentre(JPanel panelCentre) {
		this.panelCentre = panelCentre;
	}


	public PanelMois getPanelM() {
		return panelM;
	}


	public void setPanelM(PanelMois panelM) {
		this.panelM = panelM;
	}


	public CalendrierDuMois getCal() {
		return cal;
	}


	public CardLayout getGestionnaire() {
		return gestionnaire;
	}


	public void enregistreEcouteur(Controleur parC) {
		for (int i = 0 ; i<boutons.length ; i++) {
			boutons[i].addActionListener(parC) ;
		}
		
	}
}
