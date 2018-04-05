package vue;

import java.io.File;
import javax.swing.JPanel ;
import controleur.Controleur;
import modele.AgendaV2;
import modele.Date;
import modele.Evenement;
import modele.LectureEcriture;



public class PanelAgenda extends JPanel {

	private static final long serialVersionUID = 1L;
	AgendaV2 aged = new AgendaV2();
	PanelCalendrier panelC = new PanelCalendrier();
    PanelFormulaire panelF = new PanelFormulaire() ;
    Controleur ctrl = new Controleur(aged, panelF, panelC);
    File fichier = new File("FileAgenda"+File.separator+"agendas.ser");
    
    	
    
    public PanelAgenda() {
    	if (fichier.length()!=0 && fichier.isFile()) {
	    	aged.ajout(new Evenement(new Date(1,1,1999), "controle", "g26"));
	        aged.ajout(new Evenement(new Date(1,2,1999), "controle2", "g25"));
    	}
    	else {
    		aged.ajout((Evenement)LectureEcriture.lecture(fichier));
    	}
    

        this.add(panelC) ;// calendrier a gauche
        this.add(panelF) ;// formulaire a droite
    }// PanelAgenda()
}//PanelAgenda