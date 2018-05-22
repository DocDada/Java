package vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controleur.Controleur;
import modele.AgendaV2;
import outil.LectureEcriture;

public class PanelAgendaV2 extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private AgendaV2 aged = new AgendaV2();
    private PanelCalendrier panelC = new PanelCalendrier();
    private PanelFormulaire panelF = new PanelFormulaire();
    private PanelAffichage panelA;
    private Controleur ctrl;
    private CardLayout panels;
    private File fichier = new File("FileAgenda" + File.separator + "agendas.ser");

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    public PanelAgendaV2() {
        // L'ORDRE EST TRES IMPORTANT
        // instantiation de l'agenda
        // instantiation du panelAffichage, agenda en parametre
        // instantiation du controleur, panelAffichage et agenda en parametre
        if (fichier.length() != 0)
            aged = (AgendaV2) LectureEcriture.lecture(fichier);// lecture du fichier contenant l'agenda
        System.out.println(aged.toString());
        panelA = new PanelAffichage(aged);// avant le controleur ! sinon null
        ctrl = new Controleur(aged, panelF, panelC, panelA);
        setPanels(new CardLayout(5, 5));
        this.setLayout(getPanels());
        this.add(panelC, "Calendrier");// calendrier a gauche
        this.add(panelF, "Evenement");// formulaire au milieu
        this.add(panelA, "Semaine");// table d'événements à droite
    }// PanelAgenda()

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Fermer")) {
            int choix = JOptionPane.showConfirmDialog(this, "Voulez-vous fermer l'application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choix == JOptionPane.OK_OPTION)
                System.exit(1);
        }
        getPanels().show(this, e.getActionCommand());
    }

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

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

    public CardLayout getPanels() {
        return panels;
    }

    public void setPanels(CardLayout panels) {
        this.panels = panels;
    }
}
