package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controleur;
import modele.CalendrierDuMois;
import modele.Date;

public class PanelMois extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private int mois;
    private ArrayList<BoutonDate> listeBoutons;
    static final String labelJours[] = { "lu", "ma", "me", "je", "ve", "sa", "di" };
    private JLabel[] joursSemaine = new JLabel[7];
    private BoutonDate boutonSelect;

    public PanelMois(int mois) {
        this.mois = mois;
        Collection<Date> datesDuMois = new CalendrierDuMois(mois, new Date().getChAnnee()).getDates();
        this.setLayout(new GridLayout(datesDuMois.size() % 7, 7, 20, 20));
        // this.setLayout(new GridLayout(7, datesDuMois.size()/7, 20, 20)) ; // marche aussi
        // lu ma me je ve sa di
        for (int i = 0; i < labelJours.length; i++) {
            joursSemaine[i] = new JLabel(labelJours[i], JLabel.CENTER);
            this.add(joursSemaine[i]);
        }

        listeBoutons = new ArrayList<BoutonDate>();
        BoutonDate boutonJour;
        Iterator<Date> iter = datesDuMois.iterator();

        while (iter.hasNext()) {
            Date date = iter.next();// recupere date
            boutonJour = new BoutonDate(date);
            boutonJour.addActionListener(this);
            listeBoutons.add(boutonJour);// ajout du bouton a l'array list
            this.add(boutonJour);// ajout au GridLayout
            boutonJour.setDate(date);
            if (date.getChMois() != mois)
                boutonJour.setForeground(Color.CYAN);
        }
        boutonSelect = listeBoutons.get(0);
    }// PanelMois()

    ////////////////
    // ACCESSEURS //
    // ET         //
    // MODIFIEURS //
    ////////////////

    public int getMois() {
        return mois;
    }// getMois()

    public void setMois(int mois) {
        this.mois = mois;
    }// setMois()

    @Override
    public void actionPerformed(ActionEvent e) {
        boutonSelect.setCouleurs();
        // recolorie le bouton precedemment selectionne en fonction du jour :
        // aujourd'hui, le jour du mois suivant ou precedent ...
        boutonSelect = (BoutonDate) e.getSource();
        if (!boutonSelect.isSelected())// si le bouton n'a pas ete selectionne
            boutonSelect.setBackground(Color.LIGHT_GRAY);// le bouton est en gris
    }// actionPerformed()

    public void enregistreEcouteur(Controleur parC) {
        for (BoutonDate bouton : listeBoutons)
            bouton.addActionListener(parC);
    }// enregistreEcouteur()
}// PanelMois