package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modele.AgendaV2;
import modele.Date;
import modele.Evenement;
import modele.ModeleTable;
import outil.LectureEcriture;
import vue.BoutonDate;
import vue.PanelAffichage;
import vue.PanelCalendrier;
import vue.PanelFormulaire;

public class Controleur implements ActionListener {

    AgendaV2 agenda;
    PanelFormulaire panelForm;
    PanelCalendrier panelCale;
    PanelAffichage panelAffi;
    File fichier;

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    public Controleur(AgendaV2 agd, PanelFormulaire panelF, PanelCalendrier panelC, PanelAffichage panelA) {
        agenda = agd;
        panelForm = panelF;
        panelCale = panelC;
        panelAffi = panelA;
        panelForm.enregistreEcouteur(this);// le panel de saisie se met a l'ecoute
        panelCale.enregistreEcouteur(this);
        fichier = new File("FileAgenda" + File.separator + "agendas.ser");
    }// Controleur()

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("+")) {
            Evenement evt = panelForm.getEvenement();
            agenda.ajout(evt);
            // mise à jour de la JTable d'événements
            panelAffi.ajoutEvenement(evt);
            // ecriture de l'agenda dans le fichier
            LectureEcriture.ecriture(fichier, agenda);
            // affichage de l'agenda complet
            JOptionPane.showMessageDialog((JButton) e.getSource(), agenda.toString());
            // les champs du formulaires sonr re-initialisés
            panelForm.reset();
        }
        else if (e.getSource().getClass().getSimpleName().equals("BoutonDate")) {
            Date date = ((BoutonDate) e.getSource()).getDate();
            panelForm.setDate(date);
            panelAffi.setDate(new ModeleTable(date, agenda));
        }
    }// actionPerformed()
}// Controleur