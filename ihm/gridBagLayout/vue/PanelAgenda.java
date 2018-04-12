package vue;

import java.io.File;
import javax.swing.JPanel ;
import controleur.Controleur;
import modele.AgendaV2;
import outil.LectureEcriture;



public class PanelAgenda extends JPanel {

	private static final long serialVersionUID = 1L;
	AgendaV2 aged = new AgendaV2();
	PanelCalendrier panelC = new PanelCalendrier();
    PanelFormulaire panelF = new PanelFormulaire() ;
    PanelAffichage panelA = new PanelAffichage(aged);
    Controleur ctrl = new Controleur(aged, panelF, panelC, panelA);
    File fichier = new File("FileAgenda"+File.separator+"agendas.ser");

    public PanelAgenda() {

    	if (fichier.length()!=0)
	        aged=(AgendaV2)LectureEcriture.lecture(fichier);// lecture du fichier contenant l'agenda
    	System.out.println(aged.toString());
        this.add(panelC) ;// calendrier a gauche
        this.add(panelF) ;// formulaire au milieu
    	this.add(panelA);// table d'événements à droite
    }// PanelAgenda()
}//PanelAgenda