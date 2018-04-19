package vue;

import java.io.File;
import javax.swing.JPanel;
import controleur.Controleur;
import modele.AgendaV2;
import outil.LectureEcriture;

public class PanelAgenda extends JPanel {

    private static final long serialVersionUID = 1L;
    private AgendaV2 aged = new AgendaV2();
    private PanelCalendrier panelC = new PanelCalendrier();
    private PanelFormulaire panelF = new PanelFormulaire();
    private PanelAffichage panelA ;
    private Controleur ctrl;
    private File fichier = new File("FileAgenda" + File.separator + "agendas.ser");

    public PanelAgenda() {
        if (fichier.length() != 0)
            aged = (AgendaV2) LectureEcriture.lecture(fichier);// lecture du fichier contenant l'agenda
        System.out.println(aged.toString());
        ctrl = new Controleur(aged, panelF, panelC, panelA);
        panelA = new PanelAffichage(aged) ;// necessaire
        this.add(panelC);// calendrier a gauche
        this.add(panelF);// formulaire au milieu
        this.add(panelA);// table d'événements à droite
    }// PanelAgenda()

    public PanelFormulaire getPanelF() {
        return panelF;
    }

    public void setPanelF(PanelFormulaire panelF) {
        this.panelF = panelF;
    }

    public Controleur getCtrl() {
        return ctrl;
    }

    public void setCtrl(Controleur ctrl) {
        this.ctrl = ctrl;
    }
}// PanelAgenda