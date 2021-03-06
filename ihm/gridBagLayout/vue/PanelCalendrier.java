package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controleur;
import modele.Date;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class PanelCalendrier extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    static final int NB_BOUTONS_PSUD = 4;
    static final int NB_BOUTONS_PCENTRE = 45;

    JButton boutons[] = new JButton[NB_BOUTONS_PSUD];
    String intitulesBoutons[] = { "<<", "<", ">", ">>" };
    // Intitules des etiquettes
    String mois[] = { "janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "novembre", "octobre", "decembre" };
    private int moisAffiche;
    private int anneeAffiche;
    // Etiquettes
    JLabel etiquettes[] = new JLabel[NB_BOUTONS_PCENTRE];
    CardLayout gestionnaire = new CardLayout(5, 5);// jours du mois 1, 2 ...
    JPanel panelSud = new JPanel();// pour les boutons suivant, precedent etc.
    JLabel pSudEtiquette = new JLabel();// pour le mois
    JPanel panelCentre = new JPanel();// le calendrier
    PanelMois[] panelM = new PanelMois[12];

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    public PanelCalendrier() {
        this.setLayout(new BorderLayout(0, 0));
        panelCentre.setLayout(gestionnaire);

        //////////////////
        //  PANEL  SUD  //
        //////////////////

        moisAffiche = new Date().getChMois() - 1;
        pSudEtiquette.setText(Date.getChMoisString(moisAffiche + 1));
        panelSud.add(pSudEtiquette);
        this.add(panelSud, BorderLayout.SOUTH);
        // Boucle d'instantiation et d'addition a panelSud
        // bouton pour parcourir le cardLayout
        for (int bouton = 0; bouton < boutons.length; bouton++) {
            boutons[bouton] = new JButton(intitulesBoutons[bouton]);
            boutons[bouton].addActionListener(this);
            panelSud.add(boutons[bouton], intitulesBoutons[bouton]);
        }

        //////////////////
        // PANEL CENTRE //
        //////////////////

        // instantiation du tableau de PanelMois
        // un PanelMois pour un mois
        for (int i = 0; i < panelM.length; i++) {
            panelM[i] = new PanelMois(i);
            panelM[i].setOpaque(true);
            panelM[i].setBackground(new Color(200, 200, 200));
            panelCentre.add(panelM[i], Integer.toString(i));
        }
        // le panel mois qui s'affiche par defaut a pour parametre (moisAffiche+1)
        gestionnaire.show(panelCentre, Integer.toString(moisAffiche + 1));
        add(panelCentre, BorderLayout.NORTH);
    }// PanelCalendrier()

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    public void actionPerformed(ActionEvent parEvt) {
        if (parEvt.getSource() == boutons[0]) {
            gestionnaire.first(this.panelCentre);
            moisAffiche = 0;
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche + 1));
        }
        else if (parEvt.getSource() == boutons[1]) {
            if (moisAffiche > 0) {
                gestionnaire.previous(this.panelCentre);
                moisAffiche--;
                pSudEtiquette.setText(Date.getChMoisString(moisAffiche + 1));
            }
        }
        else if (parEvt.getSource() == boutons[2]) {
            if (moisAffiche < 11) {
                gestionnaire.next(this.panelCentre);
                moisAffiche++;
                pSudEtiquette.setText(Date.getChMoisString(moisAffiche + 1));
            }
        }
        else {
            gestionnaire.last(this.panelCentre);
            moisAffiche = 11;
            pSudEtiquette.setText(Date.getChMoisString(moisAffiche + 1));
        }
    }// actionPerformed()

    public void enregistreEcouteur(Controleur parC) {
        for (PanelMois panel : panelM)
            panel.enregistreEcouteur(parC);
    }// enregistreEcouteur()

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

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

    public JLabel getpSudEtiquette() {
        return pSudEtiquette;
    }

    public void setpSudEtiquette(JLabel pSudEtiquette) {
        this.pSudEtiquette = pSudEtiquette;
    }
}// PanelCalendrier