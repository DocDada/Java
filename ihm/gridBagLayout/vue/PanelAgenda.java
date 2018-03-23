package vue;

import javax.swing.JPanel ;
import controleur.Controleur;
import modele.AgendaV2;
import modele.Date;
import modele.Evenement;



public class PanelAgenda extends JPanel {
	private static final long serialVersionUID = 1L;
	AgendaV2 aged = new AgendaV2();
	PanelCalendrier panelC = new PanelCalendrier();
    PanelFormulaire panelF = new PanelFormulaire() ;
    Controleur ctrl = new Controleur(aged, panelF, panelC);
    public PanelAgenda() {
        aged.ajout(new Evenement(new Date(1,1,1999), "controle", "g26"));
        aged.ajout(new Evenement(new Date(1,2,1999), "controle2", "g25"));
        
        this.add(panelC) ;// calendrier a gauche
        this.add(panelF) ;// saisie a droite
        
    }



}